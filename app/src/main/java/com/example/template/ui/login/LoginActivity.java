package com.example.template.ui.login;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.data.bean.User;
import com.example.template.http.request.AccountRequest;
import com.example.template.ui.MainActivity;
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
        public final State<Boolean> loadingVisible = new State<>(false);
    }

    public class ClickProxy {
        public void login() {
//            Log.d("aaa:", state.username.get());
//            User user = new User();
//            user.setUsername(state.username.get());
//            accountRequest.requestLogin(user);

            MainActivity.actionStart(LoginActivity.this);
        }
    }
}