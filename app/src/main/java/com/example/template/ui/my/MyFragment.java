package com.example.template.ui.my;

import android.util.Log;
import android.view.View;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.data.bean.User;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.global.UserState;
import com.example.template.ui.play.PlayingActivity;
import com.example.template.ui.product.ProductFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.xuexiang.xui.utils.XToastUtils;

public class MyFragment extends BaseViewPagerFragment {

    private MyState state;
    private UserState userState;

    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(MyState.class);
        userState = getApplicationScopeViewModel(UserState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_my, BR.vm, state)
                .addBindingParam(BR.userVm, userState)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public static class MyState extends StateHolder {
    }

    public class ClickProxy {

        public void toBill() {
            XToastUtils.info("点击了账单");
           userState.user.get().setNickname("小学生");
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
