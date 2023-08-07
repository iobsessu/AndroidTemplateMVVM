package com.example.template.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.data.bean.User;
import com.example.template.http.request.AccountRequest;
import com.example.template.ui.MainActivity;
import com.example.template.util.TokenUtil;
import com.kunminx.architecture.ui.page.BaseActivity;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;

public class LoginActivity extends BaseActivity {

    private LoginState state;
    private AccountRequest accountRequest;

    @Override
    protected void initViewModel() {
        state = getActivityScopeViewModel(LoginState.class);
        accountRequest = getActivityScopeViewModel(AccountRequest.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_login, BR.vm, state)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public static class LoginState extends StateHolder {
        public final State<String> username = new State<>("");
        public final State<String> password = new State<>("");
        public final State<Boolean> loadingVisible = new State<>(false);
    }

    public class ClickProxy {
        public void login() {
//            Log.d("aaa:", state.username.get());
//            User user = new User();
//            user.setUsername(state.username.get());
//            accountRequest.requestLogin(user);
//            new MaterialDialog.Builder(LoginActivity.this)
//                    .iconRes(R.mipmap.icon_tip)
//                    .title(R.string.tips)
//                    .content("R.string.content_simple_confirm_dialog")
//                    .positiveText("R.string.lab_submit")
//                    .show();
//            MainActivity.actionStart(LoginActivity.this);
            TokenUtil.setToken("test_token_string");
            MainActivity.actionStart(LoginActivity.this);
            finish();
        }
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}