package com.example.template.ui.bind;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EditTextBindingAdapter {

    @BindingAdapter(value = {"onKeyListener"}, requireAll = false)
    public static void onKeyListener(TextInputEditText view, View.OnKeyListener listener) {
        view.setOnKeyListener(listener);
    }


    @BindingAdapter(value = {"editTextErrorMessage"}, requireAll = false)
    public static void editTextErrorMessage(TextInputLayout view, String message) {
        view.setError(message);
    }

}
