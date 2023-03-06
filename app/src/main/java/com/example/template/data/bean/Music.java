package com.example.template.data.bean;

import java.io.Serializable;
import java.util.Objects;

public class Music implements Serializable {

    private int id;
    private String title;
    private int playTimes;
    private String imageUrl;
    private int singerId;
    private String singerName;

    public Music(int id, String title, int playTimes, String imageUrl, int singerId, String singerName) {
        this.id = id;
        this.title = title;
        this.playTimes = playTimes;
        this.imageUrl = imageUrl;
        this.singerId = singerId;
        this.singerName = singerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(int playTimes) {
        this.playTimes = playTimes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return id == music.id && Objects.equals(title, music.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
