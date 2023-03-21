package com.example.template.ui.play;

import static com.example.template.ui.components.musicplayview.MusicPlayerView.NO_START;
import static com.example.template.ui.components.musicplayview.MusicPlayerView.PAUSED;
import static com.example.template.ui.components.musicplayview.MusicPlayerView.PLAYING;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioRouting;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.template.BR;
import com.example.template.R;
import com.example.template.databinding.ActivityPlayingBinding;
import com.example.template.ui.MainActivity;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.global.PlayerState;
import com.example.template.ui.home.HomeFragment;
import com.google.android.material.slider.Slider;
import com.kunminx.architecture.ui.page.BaseActivity;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.NumberUtil;

public class PlayingActivity extends BaseActivity {

    private PlayingState state;
    private PlayerState playerState;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, PlayingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initViewModel() {
        state = getActivityScopeViewModel(PlayingState.class);
        playerState = getApplicationScopeViewModel(PlayerState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_playing, BR.vm, state)
                .addBindingParam(BR.playerVm, playerState)
                .addBindingParam(BR.click, new ClickProxy());
    }


    public static class PlayingState extends StateHolder {

    }

    public class ClickProxy {

        public void playPause() {
            // https://www.gequbao.com/
            playerState.setMusicResource("https://cdn.tosound.com:3321/preview?file=looperman%2F0%2F113%2F627443.mp3&token=bG9vcGVybWFuJTJGMCUyRjExMyUyRjYyNzQ0My5tcDM=&sound=audio.mp3");
        }

        public Slider.OnChangeListener sliderChangeListener = ((slider, value, fromUser) -> {
            if (fromUser) {
                playerState.mediaPlayer.seekTo((int) (value * 1000));
            }
        });


    }

}
