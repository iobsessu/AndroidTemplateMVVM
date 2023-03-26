package com.example.template.ui.bind;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.databinding.BindingAdapter;

import com.example.template.data.bean.OptionItem;

import java.util.List;

public class RadioButtonBindingAdapter {

    @BindingAdapter(value = {"radioItems"}, requireAll = false)
    public static void radioItems(RadioGroup radioGroup, List<OptionItem> list) {
        RadioButton radioButton;

        for (OptionItem item: list) {
            radioButton = new RadioButton(radioGroup.getContext());
            radioButton.setText(item.getTitle());
            radioButton.setId(View.generateViewId());
            radioGroup.addView(radioButton);
        }

    }

}
