package com.dmitrenko.simplegrpcclientserver.service.impl;

import com.dmitrenko.simplegrpcclientserver.integration.grpc.client.UserApiGrpcClient;
import com.dmitrenko.simplegrpcclientserver.mapper.UserApiMapper;
import com.dmitrenko.simplegrpcclientserver.model.dto.view.UserView;
import com.dmitrenko.simplegrpcclientserver.service.UserApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static userApi.UserApiOuterClass.UserResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserApiServiceImpl implements UserApiService {

    private final UserApiGrpcClient client;

    private final UserApiMapper userApiMapper;

    @Override
    public UserView getUserInfo(String clientCode) {
        return userApiMapper.generate();
    }

    @Override
    public UserResponse getUserResponse(String clientCode) {
        return client.getUserInfo(clientCode);
    }
}
