package com.example.template.data.bean;

import java.io.Serializable;
import java.util.Objects;

public class Article implements Serializable {

    private int id;
    private String title;
    private String content;
    private String imgUrl;
    private String desc;
    private String date;
    private int type;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id && type == article.type && Objects.equals(title, article.title) && Objects.equals(content, article.content) && Objects.equals(imgUrl, article.imgUrl) && Objects.equals(desc, article.desc) && Objects.equals(date, article.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, imgUrl, desc, date, type);
    }
}
