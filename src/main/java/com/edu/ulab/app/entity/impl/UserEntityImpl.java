package com.edu.ulab.app.entity.impl;

import com.edu.ulab.app.entity.UserEntity;
import lombok.Data;

@Data
public class UserEntityImpl implements UserEntity {
    private Long id;
    private String fullName;
    private String title;
    private int age;
}
