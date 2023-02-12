package com.example.template.ui.home;

import com.example.template.BR;
import com.example.template.R;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;

public class HomeFragment extends BaseFragment {

    private HomeState state;
    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(HomeState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_home, BR.vm, state);
    }

    public static class HomeState extends StateHolder {
    }
}
