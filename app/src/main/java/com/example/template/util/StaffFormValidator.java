package com.example.template.util;

import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.ui.staff.vm.StaffFormState;

import cn.hutool.core.lang.RegexPool;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;

public class StaffFormValidator {

    public static boolean isValid(StaffFormState state) {
        boolean result = true;
        if (!isValidIdNumber(state)) {
            result = false;
        }
        if (!isValidEmail(state)) {
            result = false;
        }
        return result;
    }

    public static boolean isValidIdNumber(StaffFormState state) {
        for (FormItem formItem: state.basicFormList.get()) {
            if (formItem.getFieldName().equals("idNumber")) {
                String value = formItem.getValue();
                if (IdcardUtil.isValidCard(value)) {
                    state.idNumberError.set("");
                    return true;
                } else {
                    state.idNumberError.set(ResourceUtil.getString(R.string.id_number_error));
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidEmail(StaffFormState state) {
        for (FormItem formItem: state.basicFormList.get()) {
            if (formItem.getFieldName().equals("email")) {
                String value = formItem.getValue();
                if (ReUtil.isMatch(RegexPool.EMAIL, value)) {
                    state.emailError.set("");
                    return true;
                } else {
                    state.emailError.set(ResourceUtil.getString(R.string.email_error));
                    return false;
                }
            }
        }
        return true;
    }

}
