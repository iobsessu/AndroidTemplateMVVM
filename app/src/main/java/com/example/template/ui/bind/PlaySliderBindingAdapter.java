package com.example.template.ui.bind;

import androidx.databinding.BindingAdapter;

import com.example.template.ui.components.musicplayview.MusicPlayerView;
import com.google.android.material.slider.Slider;
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.xuexiang.xui.widget.banner.widget.banner.SimpleImageBanner;
import com.xuexiang.xui.widget.banner.widget.banner.base.BaseBanner;

public class PlaySliderBindingAdapter {

    @BindingAdapter(value = {"sliderChangeListener"}, requireAll = false)
    public static void sliderChangeListener(Slider slider, Slider.OnChangeListener onChangeListener) {
        slider.addOnChangeListener(onChangeListener);
    }
}
