package com.example.template.ui.global;

import static com.example.template.ui.components.musicplayview.MusicPlayerView.NO_START;

import com.example.template.data.bean.User;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;

public class UserState extends StateHolder {

    public State<User> user = new State<>(new User("张珊珊"));
}
