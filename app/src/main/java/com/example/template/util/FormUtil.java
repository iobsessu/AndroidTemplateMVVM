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
        FormItem formItem = new FormItem(ResourceUtil.getString(R.string.name), staff.getName(), "name");
        list.add(formItem);
        formItem = new FormItem(ResourceUtil.getString(R.string.gender), staff.getGender(), "gender");
        formItem.setType(FormItem.SWITCH);
        list.add(formItem);
        return list;
    }
}
