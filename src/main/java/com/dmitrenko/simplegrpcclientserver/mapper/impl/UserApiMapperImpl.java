package com.dmitrenko.simplegrpcclientserver.mapper.impl;

import com.dmitrenko.simplegrpcclientserver.mapper.UserApiMapper;
import com.dmitrenko.simplegrpcclientserver.model.dto.view.UserView;
import org.springframework.stereotype.Service;
import userApi.UserApiOuterClass;

import java.util.List;
import java.util.UUID;

@Service
public class UserApiMapperImpl implements UserApiMapper {

    @Override
    public UserApiOuterClass.UserResponse from(UserView source) {
        return UserApiOuterClass.UserResponse
            .newBuilder()
            .setPublicId(source.getPublicId().toString())
            .setPhone(source.getPhone())
            .addAllGroups(source.getGroups())
            .build();
    }

    @Override
    public UserView generate() {
        return new UserView()
            .setPublicId(UUID.randomUUID())
            .setPhone("1889925524")
            .setGroups(List.of(45L, 54L, 213L));
    }
}
