package com.example.template.util;

import com.example.template.R;
import com.example.template.ui.staff.vm.StaffFormState;
import com.xuexiang.xui.utils.ResUtils;

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
        if (IdcardUtil.isValidCard(state.staff.get().getIdNumber())) {
            state.idNumberError.set("");
            return true;
        } else {
            state.idNumberError.set(ResourceUtil.getString(R.string.id_number_error));
            return false;
        }
    }

    public static boolean isValidEmail(StaffFormState state) {
        if (ReUtil.isMatch(RegexPool.EMAIL, state.staff.get().getEmail())) {
            state.emailError.set("");
            return true;
        } else {
            state.emailError.set(ResourceUtil.getString(R.string.email_error));
            return false;
        }
    }

}
