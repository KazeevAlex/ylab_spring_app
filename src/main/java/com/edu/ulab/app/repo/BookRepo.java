package com.edu.ulab.app.repo;

import com.edu.ulab.app.entity.BookEntity;

import java.util.Set;

public interface BookRepo {
    void saveBook(BookEntity bookEntity);

    Set<BookEntity> getBooksByUserId(Long userId);

    void deleteBooksByUserId(Long id);
}
