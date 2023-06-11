package com.example.template.data.bean;


import java.util.Objects;

public class Carousel {

    public String imgUrl;
    public String title;

    public String getImgUrl() {
        return imgUrl;
    }

    public Carousel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Carousel setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carousel carousel = (Carousel) o;
        return Objects.equals(imgUrl, carousel.imgUrl) && Objects.equals(title, carousel.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgUrl, title);
    }
}
