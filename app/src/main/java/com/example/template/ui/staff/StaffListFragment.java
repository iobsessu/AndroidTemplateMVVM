package com.example.template.ui.staff;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.example.template.BR;
import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.data.bean.Icon;
import com.example.template.data.bean.Staff;
import com.example.template.data.dataserver.StaffData;
import com.example.template.databinding.FragmentStaffListBinding;
import com.example.template.ui.adapter.RecommendAdapter;
import com.example.template.ui.adapter.StaffAdapter;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.play.PlayingActivity;
import com.example.template.ui.staff.StaffFormActivity;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;
import com.kunminx.architecture.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class StaffListFragment extends BaseViewPagerFragment {

    private StaffListState state;
    private ClickProxy clickProxy;
    private ViewPreloadSizeProvider<Staff> preloadSizeProvider;
    private FragmentStaffListBinding binding;
    public StaffAdapter staffAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        NavHostFragment.findNavController(StaffListFragment.this).navigateUp();
        binding = (FragmentStaffListBinding) getBinding();

        RecyclerViewPreloader<Staff> preLoader = new RecyclerViewPreloader<Staff>(
                this, staffAdapter, preloadSizeProvider, 5
        );
        binding.recyclerView.addOnScrollListener(preLoader);
        binding.recyclerView.setItemViewCacheSize(0);
    }

    private void initData() {
        state.staffList.get().addAll(StaffData.getStaffList());
    }

    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(StaffListState.class);
        clickProxy = new ClickProxy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        preloadSizeProvider = new ViewPreloadSizeProvider<>();
        staffAdapter = new StaffAdapter(AppApplication.getInstance(), preloadSizeProvider);
        staffAdapter.setOnItemClickListener(((viewId, item, position) -> {
//            XToastUtils.info("点击了：" + item.getName());
            clickProxy.toEditStaff(item);
        }));

        return new DataBindingConfig(R.layout.fragment_staff_list, BR.vm, state)
                .addBindingParam(BR.click, clickProxy)
                .addBindingParam(BR.staffAdapter, staffAdapter);
    }

    public static class StaffListState extends StateHolder {

        public State<List<Staff>> staffList = new State<>(new ArrayList<>());
    }

    public class ClickProxy {
        public void toAddStaff() {
            StaffFormActivity.actionStart(getActivity());
//            BarcodeScannerOptions options = new BarcodeScannerOptions.Builder()
//                    .setBarcodeFormats(Barcode.FORMAT_QR_CODE, Barcode.FORMAT_AZTEC).build();
//            Intent intent = new Intent(this, ChooserAc)
        }

        public void toEditStaff(Staff staff) {
            StaffDetailActivity.actionStart(getActivity(), staff);
        }

    }
}
