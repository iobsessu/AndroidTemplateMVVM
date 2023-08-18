package com.example.template.ui.bind;

import androidx.databinding.BindingAdapter;

import com.example.template.ui.components.musicplayview.MusicPlayerView;
import com.example.template.ui.components.supertextview.SuperTextView;

public class TextViewBindingAdapter {

    @BindingAdapter(value = {"app:label_string"}, requireAll = false)
    public static void labelString(SuperTextView view, String value) {
        view.setLabelString(value);
    }

    @BindingAdapter(value = {"app:value_string"}, requireAll = false)
    public static void valueString(SuperTextView view, String value) {
        view.setValueString(value);
    }

}
