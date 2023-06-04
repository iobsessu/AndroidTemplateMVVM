package com.example.template.util;

import com.example.template.R;
import com.example.template.app.AppApplication;

import java.util.Date;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

public class MyDateUtil {

    public static String format(Date date) {
        return DateUtil.format(date, DatePattern.CHINESE_DATE_PATTERN);
    }

    public static String getAge(Date date) {
        if (date == null) {
            return AppApplication.getInstance().getString(R.string.unknown);
        }
        return DateUtil.ageOfNow(DateUtil.format(date, "yyyy-MM-dd")) + AppApplication.getInstance().getString(R.string.years_old);
    }
}
