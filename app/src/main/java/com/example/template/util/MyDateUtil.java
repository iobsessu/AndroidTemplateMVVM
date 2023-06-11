package com.example.template.util;

import com.example.template.R;
import com.example.template.app.AppApplication;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Date;

import cn.hutool.core.date.DateField;
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

    /**
     * 根据年份偏移量返回对应的时间。如offset=1时，return明年今天凌晨的时间
     * @param offset
     * @return
     */
    public static long getTodayByYearOffsetInUtcMilliseconds(int offset) {
        long today = MaterialDatePicker.todayInUtcMilliseconds();
        Date todayDate = DateUtil.date(today);
        Date lastYear = DateUtil.offset(todayDate, DateField.YEAR, offset);
        return lastYear.getTime();
    }
}
