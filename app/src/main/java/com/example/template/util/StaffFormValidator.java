package com.example.template.util;

import com.example.template.R;
import com.example.template.ui.staff.vm.StaffFormState;
import com.xuexiang.xui.utils.ResUtils;

import cn.hutool.core.util.IdcardUtil;

public class StaffFormValidator {

    public static boolean isValid(StaffFormState state) {
        boolean result = true;
        if (!isValidIdNumber(state)) {
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

}
