package com.example.template.ui.product;

import android.util.Log;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.play.PlayingActivity;
import com.example.template.ui.staff.StaffFormActivity;
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
        Log.d("xxx", "product");
        return new DataBindingConfig(R.layout.fragment_product, BR.vm, state)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public static class ProductState extends StateHolder {
    }

    public class ClickProxy {
        public void toAdd() {
            StaffFormActivity.actionStart(getActivity());
        }
    }
}
