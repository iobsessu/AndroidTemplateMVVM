package com.example.template.ui.staff;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.staff.vm.StaffFormState;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;

public class StaffAdditionalFormFragment extends BaseViewPagerFragment {

    private StaffFormState state;

    @Override
    protected void initViewModel() {
        state = getActivityScopeViewModel(StaffFormState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_staff_form_additional, BR.vm, state);
    }
}
