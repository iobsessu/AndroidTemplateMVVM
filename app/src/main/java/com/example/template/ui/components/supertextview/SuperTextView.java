package com.example.template.ui.components.supertextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.template.R;
import com.google.android.material.divider.MaterialDivider;

public class SuperTextView extends ConstraintLayout {

    private Context context;

    private int labelColor;
    private int valueColor;
    private int backgroundColor;

    private float labelTextSize;
    private int valueTextSize;

    private String labelString;
    private String valueString;
    private boolean showDivider;

    private ConstraintLayout wrapper;
    private TextView labelView;
    private TextView valueView;
    private LinearLayout valueLayout;
    private MaterialDivider materialDivider;

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
        valueColor = typedArray.getColor(R.styleable.MySuperTextView_value_color, 0);
        showDivider = typedArray.getBoolean(R.styleable.MySuperTextView_show_divider, false);
        labelTextSize = typedArray.getDimensionPixelSize(R.styleable.MySuperTextView_label_text_size, 0);
        valueTextSize = typedArray.getDimensionPixelSize(R.styleable.MySuperTextView_value_text_size, 0);
        labelString = typedArray.getString(R.styleable.MySuperTextView_label_string);
        valueString = typedArray.getString(R.styleable.MySuperTextView_value_string);
        typedArray.recycle();
    }

    private void initView() {
        LayoutInflater.from(context).inflate(R.layout.super_text_view, this);
        wrapper = findViewById(R.id.wrapper);
        labelView = findViewById(R.id.label);
        valueView = findViewById(R.id.value);
        valueLayout = findViewById(R.id.value_layout);
        materialDivider = findViewById(R.id.divider);

        initViewByAttrs();
    }

    private void initViewByAttrs() {
        wrapper.setBackgroundColor(backgroundColor);
        labelView.setText(labelString);
        labelView.setTextColor(labelColor);
        labelView.setTextSize(TypedValue.COMPLEX_UNIT_PX, labelTextSize);
        valueView.setText(valueString);
        valueView.setTextColor(valueColor);
        valueView.setTextSize(TypedValue.COMPLEX_UNIT_PX, labelTextSize);

        refreshDivider();
    }

    public void setLabelString(String str) {
        this.labelString = str;
        labelView.setText(str);
    }

    public void setValueString(String str) {
        this.valueString = str;
        valueView.setText(str);
    }

    public void setShowDivider(boolean visible) {
        this.showDivider = visible;
        refreshDivider();
    }

    private void refreshDivider() {
        if (showDivider) {
            materialDivider.setVisibility(VISIBLE);
        } else {
            materialDivider.setVisibility(GONE);
        }
    }

    public LinearLayout getValueLayout() {
        return valueLayout;
    }

    public TextView getValueView() {
        return valueView;
    }
}
