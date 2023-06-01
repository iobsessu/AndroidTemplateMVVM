package com.example.template.ui.my;

import android.util.Log;
import android.view.View;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.play.PlayingActivity;
import com.example.template.ui.product.ProductFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.xuexiang.xui.utils.XToastUtils;

public class MyFragment extends BaseViewPagerFragment {

    private MyState state;
    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(MyState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_my, BR.vm, state)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public static class MyState extends StateHolder {
    }

    public class ClickProxy {

        public void toBill() {
            XToastUtils.info("点击了账单");
        }
        public void toFavorite() {
            XToastUtils.info("点击了收藏");
        }

        public void toMeme() {
            XToastUtils.info("点击了表情包");
        }

        public void toCardPack() {
            XToastUtils.info("点击了卡包");
        }

        public void toSettings() {
            XToastUtils.info("点击了设置");
        }

    }
}
