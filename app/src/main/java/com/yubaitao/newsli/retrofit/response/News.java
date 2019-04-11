package com.yubaitao.newsli.retrofit.response;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "news")
public class News {
    public String author;
    @NonNull
    @PrimaryKey
    public String title;
    public String description;
    public String url;
    @SerializedName("urlToImage")
    public String image;
    @SerializedName("publishedAt")
    public String time;

    public News() {

    }

    public String getAuthor() {
        return author;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }
}