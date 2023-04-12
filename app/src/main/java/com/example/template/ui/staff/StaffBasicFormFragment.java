package com.example.template.ui.staff;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.databinding.adapters.TextViewBindingAdapter;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.staff.vm.StaffFormState;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.xuexiang.xui.utils.XToastUtils;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;

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

        public TextViewBindingAdapter.AfterTextChanged ageChangeListener = new TextViewBindingAdapter.AfterTextChanged() {
            @SuppressLint("RestrictedApi")
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    String age = StrUtil.trim(s);
                    if (StrUtil.isEmpty(age)) {
                        state.staff.get().setAge(null);
                    } else {
                        state.staff.get().setAge(Integer.valueOf(age));
                    }
                } catch (Exception e) {
                    state.staff.get().setAge(null);
                    XToastUtils.info("请输入数字");
                }
            }
        };
    }

}
