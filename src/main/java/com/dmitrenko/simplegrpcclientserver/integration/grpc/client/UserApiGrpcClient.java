package com.dmitrenko.simplegrpcclientserver.integration.grpc.client;

import userApi.UserApiOuterClass;

public interface UserApiGrpcClient {

    UserApiOuterClass.UserResponse getUserInfo(String clientCode);
}