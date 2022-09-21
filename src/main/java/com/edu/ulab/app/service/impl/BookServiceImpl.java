package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.BookEntity;
import com.edu.ulab.app.mapper.BookMapper;
import com.edu.ulab.app.repo.BookRepo;
import com.edu.ulab.app.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private static Long bookCounter = 0L;

    private final BookRepo bookRepo;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepo bookRepo, BookMapper bookMapper) {
        this.bookRepo = bookRepo;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookEntity createBook(BookDto bookDto) {
        bookDto.setId(++bookCounter);
        BookEntity bookEntity = bookMapper.bookDtoToBookEntityImpl(bookDto);
        bookRepo.saveBook(bookEntity);
        return bookEntity;
    }

//    @Override
//    public BookDto updateBook(BookDto bookDto) {
//        return null;
//    }

    @Override
    public List<BookDto> getBooksByUserId(Long userId) {
        return bookRepo.getBooksByUserId(userId)
                .stream()
                .map(bookMapper::bookEntityToBookDto)
                .toList();
    }

    @Override
    public void deleteBooksByUserId(Long id) {
        bookRepo.deleteBooksByUserId(id);
    }
}
