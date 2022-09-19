package com.edu.ulab.app.service;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.UserEntity;

public interface UserService {
    UserEntity createUser(UserDto userDto);

    void updateUser(UserDto userDto);

    UserDto getUserById(Long id);

    void deleteUserById(Long id);
}
