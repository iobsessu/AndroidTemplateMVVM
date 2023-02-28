package com.example.template.ui.product;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.home.DiscoverFragment;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;

public class ProductFragment extends BaseViewPagerFragment {

    private ProductState state;
    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(ProductState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_product, BR.vm, state);
    }

    public static class ProductState extends StateHolder {
    }
}
