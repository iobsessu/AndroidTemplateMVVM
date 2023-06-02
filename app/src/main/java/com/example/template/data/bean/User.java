package com.example.template.data.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.template.BR;

public class User extends BaseObservable {

    private String username;
    private String password;
    private String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bindable
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        notifyPropertyChanged(BR.nickname);
    }
}
