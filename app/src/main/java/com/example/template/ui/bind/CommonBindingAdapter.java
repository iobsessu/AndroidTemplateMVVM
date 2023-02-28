package com.example.template.ui.bind;

import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.template.app.AppApplication;
import com.example.template.ui.adapter.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import com.kunminx.architecture.ui.page.BaseFragment;

import java.util.List;

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

//    @BindingAdapter(value = {"headerTitle"}, requireAll = false)
//    public static void headerTitle(View view, String title) {
//
//    }

}
