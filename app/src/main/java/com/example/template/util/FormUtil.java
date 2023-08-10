package com.example.template.util;

import androidx.annotation.NonNull;

import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.data.bean.Staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormUtil {

    public static List<FormItem> generateStaffBasicFormItemList(@NonNull Staff staff) {
        List<FormItem> list = new ArrayList<>();
        FormItem formItem = new FormItem(ResUtil.getString(R.string.name), staff.getName(), "name");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.gender), formatGender(staff.getGender()), "gender");
        formItem.setType(FormItem.SINGLE_SELECT);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.birth_date), appendBirthDateStr(staff.getBirthDate()), "birthDate");
        formItem.setType(FormItem.DATE);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.id_number), staff.getIdNumber(), "idNumber");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.phone_number), staff.getPhoneNumber(), "phoneNumber");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.email), staff.getEmail(), "email");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.address), staff.getAddress(), "address");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.department_name), staff.getDepartmentName(), "departmentName");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.position_name), staff.getPositionName(), "positionName");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.job_number), staff.getJobNumber(), "jobNumber");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.hire_date), MyDateUtil.format(staff.getHireDate()), "hireDate");
        formItem.setType(FormItem.DATE);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.leave_date), MyDateUtil.format(staff.getLeaveDate()), "leaveDate");
        formItem.setType(FormItem.DATE);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.work_location), staff.getWorkLocation(), "workLocation");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.working_status), (staff.isWorkingStatus()) + "", "workingStatus");
        formItem.setType(FormItem.SINGLE_SELECT);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.weekly_hours), staff.getWeeklyWorkingHours() + "", "weeklyWorkingHours");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.salary), staff.getSalary() + "", "salary");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.annual_leave_day), staff.getAnnualLeaveDays() + "", "annualLeaveDays");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.health_status), staff.getHealthStatus() + "", "healthStatus");
        list.add(formItem);
        return list;
    }

    public static String appendBirthDateStr(Date birthDate) {
        if (birthDate == null) return "";
        String birthDateStr = MyDateUtil.format(birthDate);
        String ageStr = MyDateUtil.getAge(birthDate);
        return birthDateStr + "（" + ageStr + "）";
    }

    public static String formatGender(int gender) {
        String[] genders = ResUtil.getArray(R.array.gender_values);
        if (gender < genders.length) {
            return genders[gender];
        }
        return ResUtil.getString(R.string.unknown);
    }

}
