package com.example.template.ui.staff;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.util.Pair;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.databinding.adapters.TextViewBindingAdapter;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.ui.adapter.FormAdapter;
import com.example.template.ui.adapter.StaffAdapter;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.components.datePicker.DatePicker;
import com.example.template.ui.staff.vm.StaffFormState;
import com.example.template.util.MyDateUtil;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.xuexiang.xui.utils.XToastUtils;
import com.xuexiang.xui.widget.toast.XToast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;

public class StaffBasicFormFragment extends BaseViewPagerFragment {

    private StaffFormState state;
    public FormAdapter formAdapter;

    @Override
    protected void initViewModel() {
        state = getActivityScopeViewModel(StaffFormState.class);
        List<FormItem> basicFormList = new ArrayList<>();
        FormItem formItem = new FormItem();
        formItem.setLabel(getString(R.string.name));
        formItem.setFieldName("name");
        basicFormList.add(formItem);

        formItem = new FormItem();
        formItem.setLabel(getString(R.string.gender));
        formItem.setFieldName("gender");
        formItem.setType(FormItem.SWITCH);
        basicFormList.add(formItem);
        state.basicFormList.set(basicFormList);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        formAdapter = new FormAdapter(getActivity());
        return new DataBindingConfig(R.layout.fragment_staff_form_basic, BR.vm, state)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.formAdapter, formAdapter);
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
            long today = MaterialDatePicker.todayInUtcMilliseconds();
            DatePicker datePicker = new DatePicker(getActivity())
                    .setMax(today)
                    .setStart(MyDateUtil.getTodayByYearOffsetInUtcMilliseconds(-70))
                    .setEnd(MaterialDatePicker.todayInUtcMilliseconds())
                    .setOnPositiveListener((selection) -> {
                        state.staff.get().setBirthDate(DateUtil.date((Long)selection));
                    });
            datePicker.show();
        }
    }

}
