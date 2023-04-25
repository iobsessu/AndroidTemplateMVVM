package com.example.template.ui.product;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.example.template.BR;
import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.data.bean.Icon;
import com.example.template.data.bean.Staff;
import com.example.template.data.dataserver.StaffData;
import com.example.template.databinding.FragmentProductBinding;
import com.example.template.ui.adapter.RecommendAdapter;
import com.example.template.ui.adapter.StaffAdapter;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.play.PlayingActivity;
import com.example.template.ui.staff.StaffFormActivity;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends BaseViewPagerFragment {

    private ProductState state;
    private ViewPreloadSizeProvider<Staff> preloadSizeProvider;
    private FragmentProductBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = (FragmentProductBinding) getBinding();

        preloadSizeProvider = new ViewPreloadSizeProvider<>();
        state.staffAdapter = new StaffAdapter(AppApplication.getInstance(), preloadSizeProvider);

        RecyclerViewPreloader<Staff> preLoader = new RecyclerViewPreloader<Staff>(
                this, state.staffAdapter, preloadSizeProvider, 5
        );
        binding.recyclerView.addOnScrollListener(preLoader);
        binding.recyclerView.setItemViewCacheSize(0);
    }

    private void initData() {
        state.staffList.get().addAll(StaffData.getStaffList());
    }

    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(ProductState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_product, BR.vm, state)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public static class ProductState extends StateHolder {
        public StaffAdapter staffAdapter;
        public State<List<Staff>> staffList = new State<>(new ArrayList<>());
    }

    public class ClickProxy {
        public void toAdd() {
            StaffFormActivity.actionStart(getActivity());
        }
    }
}
