package com.example.template.ui.staff;

import android.content.DialogInterface;
import android.widget.RadioGroup;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.data.bean.OptionItem;
import com.example.template.data.bean.Staff;
import com.example.template.ui.adapter.FormAdapter;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.components.datePicker.DatePicker;
import com.example.template.ui.staff.vm.StaffFormState;
import com.example.template.util.FormUtil;
import com.example.template.util.MyDateUtil;
import com.example.template.util.ResUtil;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.binding_recyclerview.adapter.BaseDataBindingAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;

public class StaffBasicFormFragment extends BaseViewPagerFragment {

    private StaffFormState state;
    public FormAdapter formAdapter;

    @Override
    protected void initViewModel() {
        state = getActivityScopeViewModel(StaffFormState.class);
        state.basicFormList.set(FormUtil.generateStaffBasicFormItemList(state.staff.get()));
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        formAdapter = new FormAdapter(getActivity());
        ClickProxy clickProxy = new ClickProxy();
        formAdapter.setOnItemClickListener(clickProxy.onItemClickListener);
        return new DataBindingConfig(R.layout.fragment_staff_form_basic, BR.vm, state)
                .addBindingParam(BR.click, clickProxy)
                .addBindingParam(BR.formAdapter, formAdapter);
    }

    public class ClickProxy {

        public RadioGroup.OnCheckedChangeListener genderCheckListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                radioGroup.getCheckedRadioButtonId();
//                XToastUtils.info("选择了性别");
            }
        };


        public BaseDataBindingAdapter.OnItemClickListener<FormItem> onItemClickListener = (viewId, formItem, position) -> {
            boolean a = (viewId == R.id.wrapper);
            switch (formItem.getFieldName()) {
                case "gender":
                    showGenderPicker(formItem);
                    break;
                case "birthDate":
                    showBirthDatePicker(formItem);
                    break;
            }
        };

        private void showGenderPicker(FormItem formItem) {
            String[] genders = ResUtil.getArray(R.array.gender_values);
            int selectedIndex = ArrayUtil.indexOf(genders, formItem.getValue());
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.please_select_gender)
                    .setSingleChoiceItems(genders, selectedIndex, (dialogInterface, index) -> {
                        formItem.setValue(genders[index]);
                        dialogInterface.dismiss();
                    });
            builder.show();
        }

        public void showBirthDatePicker(FormItem formItem) {
            long today = MaterialDatePicker.todayInUtcMilliseconds();
            DatePicker datePicker = new DatePicker(getActivity())
                    .setMax(today)
                    .setStart(MyDateUtil.getTodayByYearOffsetInUtcMilliseconds(-70))
                    .setEnd(MaterialDatePicker.todayInUtcMilliseconds())
                    .setOnPositiveListener((selection) -> {
                        Date selectedDate = DateUtil.date((Long)selection);
                        formItem.setValue(MyDateUtil.format(selectedDate));
                    });
            datePicker.show();
        }
    }

}
