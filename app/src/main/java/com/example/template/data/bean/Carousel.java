package com.example.template.data.bean;


import androidx.annotation.DrawableRes;

import java.util.Objects;

public class Carousel {

    public String title;
    public String imgUrl;
    @DrawableRes
    public int imgUrl2;

    public String getTitle() {
        return title;
    }

    public Carousel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Carousel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public int getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(int imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carousel carousel = (Carousel) o;
        return imgUrl2 == carousel.imgUrl2 && Objects.equals(title, carousel.title) && Objects.equals(imgUrl, carousel.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, imgUrl, imgUrl2);
    }
}
