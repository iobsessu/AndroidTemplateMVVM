package com.example.template.ui.components.datePicker;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentActivity;

import com.example.template.util.MyDateUtil;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.CompositeDateValidator;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.ArrayList;

public class DatePicker {

    private FragmentActivity activity;
    private MaterialDatePicker.Builder datePickerBuilder;
    private CalendarConstraints.Builder constraintsBuilder;
    private ArrayList<CalendarConstraints.DateValidator> validatorList = new ArrayList<>();
    private MaterialPickerOnPositiveButtonClickListener onPositiveListener;

    public DatePicker(FragmentActivity activity) {
        this.activity = activity;
        datePickerBuilder = MaterialDatePicker.Builder.datePicker();
        constraintsBuilder = new CalendarConstraints.Builder();
    }

    public DatePicker setMin(long minDate) {
        CalendarConstraints.DateValidator validatorMin = DateValidatorPointForward.from(minDate);
        validatorList.add(validatorMin);
        return this;
    }

    public DatePicker setMax(long maxDate) {
        CalendarConstraints.DateValidator validatorMax = DateValidatorPointBackward.before(maxDate);
        validatorList.add(validatorMax);
        return this;
    }

    public DatePicker setStart(long startDate) {
        constraintsBuilder.setStart(startDate);
        return this;
    }

    public DatePicker setEnd(long endDate) {
        constraintsBuilder.setEnd(endDate);
        return this;
    }

    public DatePicker setOnPositiveListener(MaterialPickerOnPositiveButtonClickListener onPositiveListener) {
        this.onPositiveListener = onPositiveListener;
        return this;
    }

    public void show() {
        CalendarConstraints.DateValidator validators = CompositeDateValidator.allOf(validatorList);
        constraintsBuilder.setValidator(validators);
        datePickerBuilder.setCalendarConstraints(constraintsBuilder.build());

        MaterialDatePicker datePicker = datePickerBuilder.build();
        if (onPositiveListener != null) {
            datePicker.addOnPositiveButtonClickListener(onPositiveListener);
        }
        datePicker.show(activity.getSupportFragmentManager(), "");
    }
}
