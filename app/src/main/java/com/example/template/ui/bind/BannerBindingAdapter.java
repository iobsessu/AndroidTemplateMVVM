package com.example.template.ui.bind;

import androidx.databinding.BindingAdapter;

import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.xuexiang.xui.widget.banner.widget.banner.SimpleImageBanner;
import com.xuexiang.xui.widget.banner.widget.banner.base.BaseBanner;

import java.util.List;

public class BannerBindingAdapter {

    @BindingAdapter(value = {"bannerSource"}, requireAll = false)
    public static void bannerSource(SimpleImageBanner banner, List<BannerItem> list) {
        banner.setSource(list).setIsOnePageLoop(false).startScroll();
    }

    @BindingAdapter(value = {"itemClickListener"}, requireAll = false)
    public static void itemClickListener(SimpleImageBanner banner, BaseBanner.OnItemClickListener<BannerItem> onItemClickListener) {
        banner.setOnItemClickListener(onItemClickListener);
    }


}
