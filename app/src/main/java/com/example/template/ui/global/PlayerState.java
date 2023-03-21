package com.example.template.ui.global;

import static com.example.template.ui.components.musicplayview.MusicPlayerView.NO_START;
import static com.example.template.ui.components.musicplayview.MusicPlayerView.PAUSED;
import static com.example.template.ui.components.musicplayview.MusicPlayerView.PLAYING;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;

import com.example.template.app.AppApplication;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;

import java.util.concurrent.TimeUnit;

public class PlayerState extends StateHolder {

    public State<String> imageUrl = new State<>("http://p2.music.126.net/g2_Gv0dtAicJ3ChTYu28_g==/1393081239628722.jpg?imageView=1&type=webp&thumbnail=246x0");
    public State<Integer> playingStatus = new State<>(NO_START);
    public State<Integer> musicDuration = new State<>(1);
    public State<Integer> musicProgressValue = new State<>(0);
    public State<String> musicDurationStr = new State<>("00:00");
    public State<String> musicName = new State<>("No Princess");
    public State<String> singer = new State<>("Mario1");
    public MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int position = mediaPlayer.getCurrentPosition();
            musicProgressValue.set(position / 1000);
            if (mediaPlayer.isPlaying()) {
                handler.postDelayed(this, 1000);
            }
        }
    };

    public void setMusicResource(String url) {
        mediaPlayer = MediaPlayer.create(AppApplication.getInstance(), Uri.parse(url));
        int duration = mediaPlayer.getDuration();
        musicDuration.set(duration / 1000);

        musicDurationStr.set(longToMinuteSecond(duration));

        MediaPlayer.TrackInfo[] trackInfo = mediaPlayer.getTrackInfo();
        if (trackInfo.length > 0) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                playingStatus.set(PAUSED);
            } else {
                mediaPlayer.start();
                playingStatus.set(PLAYING);
                handler.post(runnable);
            }
        } else {
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(mp -> {
                mp.start();
                playingStatus.set(PLAYING);
            });
        }
    }

    private String longToMinuteSecond(long time) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - minutes * 60;
        return minutes + ":" + seconds;
    }

    public void init() {
        if (mediaPlayer == null) {


        }
    }
}
