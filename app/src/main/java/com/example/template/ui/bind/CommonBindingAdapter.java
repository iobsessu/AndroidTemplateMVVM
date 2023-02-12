package com.example.template.ui.bind;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class CommonBindingAdapter {

    @BindingAdapter(value = {"visible"}, requireAll = false)
    public static void visible(View view, boolean visible) {
        if (visible && view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        } else if (!visible && view.getVisibility() ==View.VISIBLE) {
            view.setVisibility(View.GONE);
        }
    }

    @BindingAdapter(value = {"invisible"}, requireAll = false)
    public static void invisible(View view, boolean visible) {
        if (visible && view.getVisibility() == View.INVISIBLE) {
            view.setVisibility(View.VISIBLE);
        } else if (!visible && view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.INVISIBLE);
        }
    }
}
