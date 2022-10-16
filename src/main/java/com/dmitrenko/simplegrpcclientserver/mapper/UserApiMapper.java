package com.dmitrenko.simplegrpcclientserver.mapper;

import com.dmitrenko.simplegrpcclientserver.model.dto.view.UserView;
import userApi.UserApiOuterClass;

public interface UserApiMapper {

    UserApiOuterClass.UserResponse from(UserView source);

    UserView generate();
}
