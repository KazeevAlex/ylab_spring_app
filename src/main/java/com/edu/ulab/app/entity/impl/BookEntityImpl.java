package com.edu.ulab.app.entity.impl;

import com.edu.ulab.app.entity.BookEntity;

public class BookEntityImpl implements BookEntity {

    private static Long bookCounter = 0L;

    private Long id;
    private Long userId;
    private String title;
    private String author;
    private long pageCount;

    {
        id = ++bookCounter;
    }

    public BookEntityImpl(Long userId, String title, String author, long pageCount) {
        this.userId = userId;
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public long getPageCount() {
        return pageCount;
    }
}
