package com.example.template.ui.bind;

import android.view.Gravity;
import android.view.View;

import androidx.databinding.BindingAdapter;

import com.google.android.material.badge.BadgeUtils;
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.xuexiang.xui.widget.banner.widget.banner.SimpleImageBanner;
import com.xuexiang.xui.widget.textview.badge.BadgeView;

import java.util.List;

public class BadgeBindingAdapter {

    @BindingAdapter(value = {"badgeNum"}, requireAll = false)
    public static void badgeNum(View view, int number) {
        new BadgeView(view.getContext())
                .bindTarget(view)
                .setBadgeNumber(number)
                .setBadgeGravity(Gravity.TOP | Gravity.END)
                .setShowShadow(false);
    }


}
