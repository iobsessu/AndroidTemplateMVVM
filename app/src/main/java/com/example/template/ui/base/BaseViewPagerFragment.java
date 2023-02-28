package com.example.template.ui.base;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.kunminx.architecture.ui.page.BaseFragment;

public abstract class BaseViewPagerFragment extends BaseFragment {

    @StringRes
    private int title;

    @DrawableRes
    private int icon;

    public @StringRes int getTitle() {
        return title;
    }

    public void setTitle(@StringRes int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
