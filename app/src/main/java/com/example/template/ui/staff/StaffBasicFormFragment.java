package com.example.template.ui.staff;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.util.Pair;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.databinding.adapters.TextViewBindingAdapter;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.components.datePicker.DatePicker;
import com.example.template.ui.staff.vm.StaffFormState;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.xuexiang.xui.utils.XToastUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import cn.hutool.core.date.DateUtil;
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

        public void showDatePicker() {
            long today = MaterialDatePicker.todayInUtcMilliseconds() -1;
            Calendar utc = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            utc.clear();
            DatePicker datePicker = new DatePicker(getActivity())
                    .setMin(today)
                    .setOnPositiveListener(new MaterialPickerOnPositiveButtonClickListener() {
                        @Override
                        public void onPositiveButtonClick(Object selection) {

                        }
                    });
            datePicker.show();
        }
    }

}
