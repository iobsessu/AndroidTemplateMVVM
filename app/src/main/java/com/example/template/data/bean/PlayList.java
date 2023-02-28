package com.example.template.data.bean;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.Objects;

public class PlayList implements Serializable {

    private int id;
    private String title;
    private int playTimes;
    private String imageUrl;

    public PlayList(int id, String title, int playTimes, String imageUrl) {
        this.id = id;
        this.title = title;
        this.playTimes = playTimes;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayTimes() {
        return playTimes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return id == playList.id && Objects.equals(title, playList.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
