package com.edu.ulab.app.repo.impl;

import com.edu.ulab.app.entity.BookEntity;
import com.edu.ulab.app.exception.NotFoundException;
import com.edu.ulab.app.repo.BookRepo;
import com.edu.ulab.app.storage.Storage;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class BookRepoImpl implements BookRepo {

    private final HashMap<Long, Set<BookEntity>> booksByUserId;

    {
        booksByUserId = Storage.getInstance().getBooksByUserId();
    }

    @Override
    public void saveBook(BookEntity bookEntity) {
        Long userId = bookEntity.getUserId();
        if (booksByUserId.get(userId) == null) {
            booksByUserId.put(userId, new HashSet<>(List.of(bookEntity)));
        } else {
            booksByUserId.get(userId).add(bookEntity);
        }
    }

    @Override
    public Set<BookEntity> getBooksByUserId(Long userId) {
        Set<BookEntity> bookEntities = booksByUserId.get(userId);
        if (bookEntities == null) {
            throw new NotFoundException("User with the specified ID does not exist.");
        }
        return bookEntities;
    }

    @Override
    public void deleteBooksByUserId(Long id) {
        booksByUserId.remove(id);
    }
}
