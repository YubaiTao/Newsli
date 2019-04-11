package com.yubaitao.newsli.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.yubaitao.newsli.retrofit.response.News;

@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);
}
