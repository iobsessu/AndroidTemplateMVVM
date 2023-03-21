package com.example.template.ui.bind;

import static com.example.template.ui.components.musicplayview.MusicPlayerView.NO_START;
import static com.example.template.ui.components.musicplayview.MusicPlayerView.PAUSED;
import static com.example.template.ui.components.musicplayview.MusicPlayerView.PLAYING;

import android.animation.ObjectAnimator;
import android.graphics.drawable.RotateDrawable;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.template.R;
import com.example.template.ui.components.musicplayview.MusicPlayerView;
import com.example.template.ui.play.PlayingActivity;

import de.hdodenhof.circleimageview.CircleImageView;

//import co.mobiwise.library.MusicPlayerView;

public class MusicPlayViewBindingAdapter {

    @BindingAdapter(value = {"imageUrl"}, requireAll = false)
    public static void imageUrl(MusicPlayerView view, String imageUrl) {
        view.setCoverUrl(imageUrl);
    }

    @BindingAdapter(value = {"playStatus"}, requireAll = false)
    public static void playStatus(MusicPlayerView view, int playStatus) {
        if (playStatus == NO_START) {
            view.stop();
        } else if (playStatus == PLAYING) {
            view.start();
        } else if (playStatus == PAUSED) {
            view.pause();
        }
    }



}
