package com.edu.ulab.app.repo;

import com.edu.ulab.app.entity.UserEntity;

public interface UserRepo {
    void saveUser(UserEntity userEntity);

    UserEntity getUserById(Long userId);

    void deleteUserById(Long id);
}
