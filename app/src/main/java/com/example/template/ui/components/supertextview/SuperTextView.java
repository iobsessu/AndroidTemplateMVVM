package com.example.template.ui.components.supertextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.template.R;
import com.xuexiang.xui.utils.ThemeUtils;

public class SuperTextView extends ConstraintLayout {

    private Context context;

    private int labelColor;
    private int valueColor;
    private int backgroundColor;

    private float labelTextSize;
    private int valueTextSize;

    private String labelString;
    private String valueString;

    private ConstraintLayout wrapper;
    private TextView labelView;

    public SuperTextView(@NonNull Context context) {
        super(context);
    }

    public SuperTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public SuperTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    public SuperTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        this.context = context;
//        defaultLabelColor = ThemeUtils.resolveColor(context, R.attr.label_color, ContextCompat.getColor(context, R.color.text_white));
//        defaultBackgroundColor = ThemeUtils.resolveColor(context, R.attr.background_color, ContextCompat.getColor(context, R.color.text_error));




        getAttr(attrs);
        initView();
    }

    private void getAttr(AttributeSet attrs) {
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MySuperTextView);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MySuperTextView, R.attr.SuperTextViewStyle, 0);
        backgroundColor = typedArray.getColor(R.styleable.MySuperTextView_background_color, 0);
        labelColor = typedArray.getColor(R.styleable.MySuperTextView_label_color, 0);
        labelTextSize = typedArray.getDimensionPixelSize(R.styleable.MySuperTextView_label_text_size, 0);
        labelString = typedArray.getString(R.styleable.MySuperTextView_label_string);
        typedArray.recycle();
    }

    private void initView() {
        LayoutInflater.from(context).inflate(R.layout.super_text_view, this);

        wrapper = findViewById(R.id.wrapper);
        wrapper.setBackgroundColor(backgroundColor);

        labelView = findViewById(R.id.label);
        labelView.setText(labelString);
        labelView.setTextColor(labelColor);
        labelView.setTextSize(TypedValue.COMPLEX_UNIT_PX, labelTextSize);
    }

}
