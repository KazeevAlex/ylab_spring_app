package com.edu.ulab.app.entity.impl;

import com.edu.ulab.app.entity.BookEntity;
import lombok.Data;

@Data
public class BookEntityImpl implements BookEntity {
    private Long id;
    private Long userId;
    private String title;
    private String author;
    private long pageCount;
}
