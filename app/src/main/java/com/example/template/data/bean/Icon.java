package com.example.template.data.bean;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import java.util.Objects;

public class Icon {

    @StringRes
    private int title;
    @DrawableRes
    private int iconRes;

    public Icon(int title, int iconRes) {
        this.title = title;
        this.iconRes = iconRes;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Icon icon = (Icon) o;
        return title == icon.title && iconRes == icon.iconRes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, iconRes);
    }
}
