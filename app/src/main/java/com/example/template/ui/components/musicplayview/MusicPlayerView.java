package com.example.template.ui.components.musicplayview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.bumptech.glide.Glide;
import com.example.template.R;


import de.hdodenhof.circleimageview.CircleImageView;

public class MusicPlayerView extends CircleImageView {

    public static final int NO_START = 0;
    public static final int PLAYING = 1;
    public static final int PAUSED = 2;
    private static final long PLAY_ANIMATION_DURATION = 8000;

    private int playStatus;
    private Animator pausePlayAnim;
    private boolean pausing;

    public MusicPlayerView(Context context) {
        super(context);
        init(context, null);
    }

    public MusicPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MusicPlayerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MusicPlayerView);

        playStatus = NO_START;
        pausePlayAnim = getPausePlayAnimator();
        updateCoverRotate();
    }

    public void start() {
        playStatus = PLAYING;
        updateCoverRotate();
        pausing = false;
    }

    public void pause() {
        playStatus = PAUSED;
        updateCoverRotate();
        pausing = true;
    }

    public void stop() {
        pausing = false;
        playStatus = NO_START;
        updateCoverRotate();
        postInvalidate();
    }

    public void setCoverUrl(String imageUrl) {
        Glide.with(getContext())
                .load(imageUrl)
                .into(this);
    }

    /**
     * Animate play/pause image
     */
    public void updateCoverRotate() {
        if (playStatus == NO_START) {
            pausePlayAnim.cancel();
        } else if (playStatus == PLAYING) {
            startRotate();
        } else if (playStatus == PAUSED) {
            pausePlayAnim.pause();
        }
    }

    private void startRotate() {
        if (pausing) {
            pausePlayAnim.resume();
        } else {
            pausePlayAnim.start();
        }
    }

    public Animator getPausePlayAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "rotation", 0f, 360f);
        animator.setDuration(PLAY_ANIMATION_DURATION);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        return animator;
    }

}
