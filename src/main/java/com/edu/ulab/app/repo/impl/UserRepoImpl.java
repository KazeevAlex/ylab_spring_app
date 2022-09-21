package com.edu.ulab.app.repo.impl;

import com.edu.ulab.app.entity.UserEntity;
import com.edu.ulab.app.exception.NotFoundException;
import com.edu.ulab.app.repo.UserRepo;
import com.edu.ulab.app.storage.Storage;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepoImpl implements UserRepo {

    private final HashMap<Long, UserEntity> users;

    {
        users = Storage.getInstance().getUsers();
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        users.put(userEntity.getId(), userEntity);
    }

    @Override
    public UserEntity getUserById(Long userId) {
        UserEntity userEntity = users.get(userId);
        if (userEntity == null) {
            throw new NotFoundException("User with the specified ID does not exist.");
        }
        return userEntity;
    }

    @Override
    public void deleteUserById(Long id) {
        if (!isExisting(id)) {
            throw new NotFoundException("User with the specified ID does not exist.");
        }
        users.remove(id);
    }

    @Override
    public boolean isExisting(Long id) {
        return users.containsKey(id);
    }
}
