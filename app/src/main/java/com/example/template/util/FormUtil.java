package com.example.template.util;

import androidx.annotation.NonNull;

import com.example.template.R;
import com.example.template.common.Constants;
import com.example.template.data.bean.FormItem;
import com.example.template.data.bean.Staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hutool.core.util.NumberUtil;

public class FormUtil {

    public static List<FormItem> generateBasicFormItemListByStaff(@NonNull Staff staff) {
        List<FormItem> basicFormItemList = generateStaffBasicFormItemList(staff);
        return basicFormItemList;
    }

    public static List<FormItem> generateStaffBasicFormItemList(Staff staff) {
        List<FormItem> list = new ArrayList<>();
        FormItem formItem = new FormItem(ResUtil.getString(R.string.name), "name");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.gender), "gender");
        formItem.setType(FormItem.SINGLE_SELECT);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.birth_date), "birthDate");
        formItem.setType(FormItem.DATE);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.id_number), "idNumber");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.phone_number), "phoneNumber");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.email), "email");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.address), "address");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.department_name), "departmentName");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.position_name), "positionName");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.job_number), "jobNumber");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.hire_date), "hireDate");
        formItem.setType(FormItem.DATE);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.working_status), "workingStatus");
        formItem.setType(FormItem.SINGLE_SELECT);
        list.add(formItem);
        if (staff.getWorkingStatus() == 1) {
            formItem = new FormItem(ResUtil.getString(R.string.leave_date), "leaveDate");
            formItem.setType(FormItem.DATE);
            list.add(formItem);
        }
        formItem = new FormItem(ResUtil.getString(R.string.work_location), "workLocation");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.weekly_hours), "weeklyWorkingHours");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.salary), "salary");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.annual_leave_day), "annualLeaveDays");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.health_status), "healthStatus");
        list.add(formItem);
        return list;
    }

    public static String appendBirthDateStr(Date birthDate) {
        if (birthDate == null) return "";
        String birthDateStr = MyDateUtil.format(birthDate);
        String ageStr = MyDateUtil.getAge(birthDate);
        return birthDateStr + "（" + ageStr + "）";
    }

    public static String formatGender(int value) {
        String[] genderArray = ResUtil.getArray(R.array.gender_values);
        if (value < genderArray.length) {
            return genderArray[value];
        }
        return ResUtil.getString(R.string.unknown);
    }

    public static String formatWorkStatus(int value) {
        String[] workingStatusArray = ResUtil.getArray(R.array.working_status_values);
        if (value < workingStatusArray.length) {
            return workingStatusArray[value];
        }
        return ResUtil.getString(R.string.unknown);
    }

    public static void setErrorMessageByField(List<FormItem> formItemList, String fieldName, String errorMessage) {
        if (formItemList == null || fieldName == null) {
            return;
        }
        for (FormItem formItem: formItemList) {
            if (formItem.getFieldName().equals(fieldName)) {
                formItem.setErrorMessage(errorMessage);
                return;
            }
        }
    }


}
