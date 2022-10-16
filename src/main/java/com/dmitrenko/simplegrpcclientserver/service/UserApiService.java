package com.dmitrenko.simplegrpcclientserver.service;

import com.dmitrenko.simplegrpcclientserver.model.dto.view.UserView;
import userApi.UserApiOuterClass.UserResponse;

public interface UserApiService {

    UserView getUserInfo(String clientCode);

    UserResponse getUserResponse(String clientCode);
}
