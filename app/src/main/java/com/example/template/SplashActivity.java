package com.example.template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.template.ui.MainActivity;
import com.example.template.ui.login.LoginActivity;
import com.example.template.util.TokenUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        toNextActivity();
    }

    protected void toNextActivity() {
        if (TokenUtil.hasToken()) {
            MainActivity.actionStart(this);
        } else {
            LoginActivity.actionStart(this);
        }
        finish();
    }


}