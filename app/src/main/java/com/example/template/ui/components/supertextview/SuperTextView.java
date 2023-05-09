package com.example.template.ui.components.supertextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
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

    private int defaultLabelColor;
    private int defaultValueColor;

    private int defaultLabelTextSize;
    private int defaultValueTextSize;

    private String labelString;
    private String valueString;

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
        defaultLabelColor = ThemeUtils.resolveColor(context, R.attr.label_color, ContextCompat.getColor(context, R.color.text_white));
        getAttr(attrs);
        initView();
    }

    private void getAttr(AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SuperTextView);
        labelString = typedArray.getString(R.styleable.SuperTextView_label_string);
        typedArray.recycle();
    }

    private void initView() {
        LayoutInflater.from(context).inflate(R.layout.super_text_view, this);
        labelView = findViewById(R.id.label);
        labelView.setText(labelString);
        labelView.setTextColor(defaultLabelColor);
    }

}
