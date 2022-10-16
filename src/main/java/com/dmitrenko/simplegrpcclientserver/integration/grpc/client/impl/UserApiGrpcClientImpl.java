package com.dmitrenko.simplegrpcclientserver.integration.grpc.client.impl;

import com.dmitrenko.simplegrpcclientserver.integration.grpc.client.UserApiGrpcClient;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import userApi.UserApiGrpc;

import static userApi.UserApiOuterClass.UserByClientCodeRequest;
import static userApi.UserApiOuterClass.UserResponse;

@Service
@RequiredArgsConstructor
public class UserApiGrpcClientImpl implements UserApiGrpcClient {

    @Value("${grpc.client.user-api.url}")
    private String url;

    @Override
    public UserResponse getUserInfo(String clientCode) {
        var channel = ManagedChannelBuilder.forTarget(url)
            .usePlaintext()
            .build();

        var stub = UserApiGrpc.newBlockingStub(channel);

        var response = stub.getUserByClientCode(UserByClientCodeRequest
            .newBuilder()
            .setClientCode(clientCode)
            .build());

        channel.shutdownNow();
        return response;
    }
}