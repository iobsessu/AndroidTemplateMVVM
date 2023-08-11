package com.example.template.util;

import androidx.annotation.NonNull;

import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.data.bean.Staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormUtil {

    public static List<FormItem> generateBasicFormItemListByStaff(@NonNull Staff staff) {
        List<FormItem> basicFormItemList = generateStaffBasicFormItemList();
        return setValueToForm(basicFormItemList, staff);
    }
    public static List<FormItem> generateStaffBasicFormItemList() {
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
        formItem.setType(FormItem.INPUT_VERTICAL);
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
        formItem = new FormItem(ResUtil.getString(R.string.leave_date), "leaveDate");
        formItem.setType(FormItem.DATE);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.work_location), "workLocation");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.working_status), "workingStatus");
        formItem.setType(FormItem.SINGLE_SELECT);
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
    public static List<FormItem> setValueToForm(@NonNull List<FormItem> formItemList, Staff staff) {
        for (FormItem item: formItemList) {
            switch (item.getFieldName()) {
                case "name":
                    item.setValue(staff.getName());
                    break;
                case "birthDate":
                    item.setValue(appendBirthDateStr(staff.getBirthDate()));
                    break;
                case "idNumber":
                    item.setValue(staff.getIdNumber());
                    break;
                case "phoneNumber":
                    item.setValue(staff.getPhoneNumber());
                    break;
                case "email":
                    item.setValue(staff.getEmail());
                    break;
                case "address":
                    item.setValue(staff.getAddress());
                    break;
                case "departmentName":
                    item.setValue(staff.getDepartmentName());
                    break;
                case "positionName":
                    item.setValue(staff.getPositionName());
                    break;
                case "jobNumber":
                    item.setValue(staff.getJobNumber());
                    break;
                case "hireDate":
                    item.setValue(MyDateUtil.format(staff.getHireDate()));
                    break;
                case "leaveDate":
                    item.setValue(MyDateUtil.format(staff.getLeaveDate()));
                    break;
                case "workLocation":
                    item.setValue(staff.getWorkLocation());
                    break;
                case "weeklyWorkingHours":
                    item.setValue(staff.getWeeklyWorkingHours() + "");
                    break;
                case "salary":
                    item.setValue(staff.getSalary() + "");
                    break;
                case "annualLeaveDays":
                    item.setValue(staff.getAnnualLeaveDays() + "");
                    break;
                case "healthStatus":
                    item.setValue(staff.getHealthStatus() + "");
                    break;
            }
        }
        return formItemList;
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


}
