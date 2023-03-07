package com.example.template.ui.my;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.product.ProductFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;

public class MyFragment extends BaseViewPagerFragment {

    private MyState state;
    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(MyState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_my, BR.vm, state);
    }

    public static class MyState extends StateHolder {
    }
}
