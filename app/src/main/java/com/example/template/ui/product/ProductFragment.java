package com.example.template.ui.product;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.data.bean.Icon;
import com.example.template.data.bean.Staff;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        Staff staff = new Staff();
        staff.setName("张三");
        state.staffList.get().add(staff);
        staff = new Staff();
        staff.setName("李四");
        state.staffList.get().add(staff);
    }

    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(ProductState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        Log.d("xxx", "product");
        return new DataBindingConfig(R.layout.fragment_product, BR.vm, state)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public static class ProductState extends StateHolder {
        public StaffAdapter staffAdapter = new StaffAdapter(AppApplication.getInstance());
        public State<List<Staff>> staffList = new State<>(new ArrayList<>());
    }

    public class ClickProxy {
        public void toAdd() {
            StaffFormActivity.actionStart(getActivity());
        }
    }
}
