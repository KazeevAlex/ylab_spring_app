package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.UserEntity;
import com.edu.ulab.app.mapper.UserMapper;
import com.edu.ulab.app.repo.UserRepo;
import com.edu.ulab.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private static Long userCounter = 0L;

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserEntity createUser(UserDto userDto) {
        // сгенерировать идентификатор
        // создать пользователя
        // вернуть сохраненного пользователя со всеми необходимыми полями id
        userDto.setId(++userCounter);
        UserEntity userEntity = userMapper.userDtoToUserEntityImpl(userDto);
        userRepo.saveUser(userEntity);
        return userEntity;
    }

    @Override
    public void updateUser(UserDto userDto) {
        UserEntity userEntity = userMapper.userDtoToUserEntityImpl(userDto);
        userRepo.saveUser(userEntity);
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity = userRepo.getUserById(id);
        return userMapper.userEntityToUserDto(userEntity);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteUserById(id);
    }
}
