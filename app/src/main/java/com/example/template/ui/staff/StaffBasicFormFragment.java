package com.example.template.ui.staff;

import android.widget.RadioGroup;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.ui.adapter.BasicFormAdapter;
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

import java.util.Date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;

public class StaffBasicFormFragment extends BaseViewPagerFragment {

    private StaffFormState state;
    private ClickProxy clickProxy;
    public BasicFormAdapter formAdapter;

    @Override
    protected void initViewModel() {
        state = getApplicationScopeViewModel(StaffFormState.class);
        state.basicFormList.set(FormUtil.generateBasicFormItemListByStaff(state.staff.get()));
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        formAdapter = new BasicFormAdapter(getActivity(), state.staff.get());
        clickProxy = new ClickProxy();
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
                    showGenderPicker(position);
                    break;
                case "birthDate":
                    showBirthDatePicker(formItem);
                    break;
                case "workingStatus":
                    showWorkingStatusPicker(position);
                    break;
            }
        };

        private void showGenderPicker(int position) {
            String[] genderArray = ResUtil.getArray(R.array.gender_values);
            int gender = state.staff.get().getGender();
            int selectedIndex = gender < genderArray.length ? gender : -1;
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.please_select_gender)
                    .setSingleChoiceItems(genderArray, selectedIndex, (dialogInterface, index) -> {
                        state.staff.get().setGender(index);
                        dialogInterface.dismiss();
                        formAdapter.notifyItemChanged(position);
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

        private void showWorkingStatusPicker(int position) {
            String[] workingStatusArray = ResUtil.getArray(R.array.working_status_values);
            int workingStatus = state.staff.get().getWorkingStatus();
            int selectedIndex = workingStatus < workingStatusArray.length ? workingStatus : -1;
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.please_select_working_status)
                    .setSingleChoiceItems(workingStatusArray, selectedIndex, (dialogInterface, index) -> {
                        state.staff.get().setWorkingStatus(index);
                        dialogInterface.dismiss();
                        formAdapter.notifyItemChanged(position);
                    });
            builder.show();
        }
    }

}
