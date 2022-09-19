package com.edu.ulab.app.service;


import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.BookEntity;

import java.util.List;

public interface BookService {
    BookEntity createBook(BookDto userDto);

//    BookDto updateBook(BookDto userDto);

    List<BookDto> getBooksByUserId(Long id);

    void deleteBooksByUserId(Long id);
}
