package com.edu.ulab.app.storage;

import com.edu.ulab.app.entity.BookEntity;
import com.edu.ulab.app.entity.UserEntity;

import java.util.HashMap;
import java.util.Set;

public class Storage {
    //todo создать хранилище в котором будут содержаться данные
    // сделать абстракции через которые можно будет производить операции с хранилищем
    // продумать логику поиска и сохранения
    // продумать возможные ошибки
    // учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
    // продумать что у узера может быть много книг и нужно создать эту связь
    // так же учесть, что методы хранилища принимают друго тип данных - учесть это в абстракции

    private static Storage instance;

    private final HashMap<Long, UserEntity> users;
    private final HashMap<Long, Set<BookEntity>> booksByUserId;

    private Storage() {
        users = new HashMap<>();
        booksByUserId = new HashMap<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public HashMap<Long, UserEntity> getUsers() {
        return users;
    }

    public HashMap<Long, Set<BookEntity>> getBooksByUserId() {
        return booksByUserId;
    }
}
