package com.example.template.ui.staff;

import android.widget.RadioGroup;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.staff.vm.StaffFormState;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.xuexiang.xui.utils.XToastUtils;

import cn.hutool.core.util.ReUtil;

public class StaffBasicFormFragment extends BaseViewPagerFragment {

    private StaffFormState state;

    @Override
    protected void initViewModel() {
        state = getActivityScopeViewModel(StaffFormState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_staff_form_basic, BR.vm, state)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public class ClickProxy {

        public RadioGroup.OnCheckedChangeListener genderCheckListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                radioGroup.getCheckedRadioButtonId();
                XToastUtils.info("选择了性别");
            }
        };
    }

}
