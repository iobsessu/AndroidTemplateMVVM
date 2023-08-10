package com.example.template.util;

import androidx.annotation.NonNull;

import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.data.bean.Staff;

import java.util.ArrayList;
import java.util.List;

public class FormUtil {

    public static List<FormItem> generateStaffBasicFormItemList(@NonNull Staff staff) {
        List<FormItem> list = new ArrayList<>();
        FormItem formItem = new FormItem(ResUtil.getString(R.string.name), staff.getName(), "name");
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.gender), formatGender(staff.getGender()), "gender");
        formItem.setType(FormItem.SINGLE_SELECT);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.birth_date), MyDateUtil.format(staff.getBirthDate()), "birthDate");
        formItem.setType(FormItem.DATE);
        list.add(formItem);
        formItem = new FormItem(ResUtil.getString(R.string.age), staff.getBirthDate() +"", "birthDate");
        formItem.setType(FormItem.DATE);
        list.add(formItem);

        return list;
    }

    public static String formatGender(int gender) {
        String[] genders = ResUtil.getArray(R.array.gender_values);
        if (gender < genders.length) {
            return genders[gender];
        }
        return ResUtil.getString(R.string.unknown);
    }

}
