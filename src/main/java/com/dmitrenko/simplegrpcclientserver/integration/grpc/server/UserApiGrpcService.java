package com.dmitrenko.simplegrpcclientserver.integration.grpc.server;

import com.dmitrenko.simplegrpcclientserver.exception.IntegrationException;
import com.dmitrenko.simplegrpcclientserver.mapper.UserApiMapper;
import com.dmitrenko.simplegrpcclientserver.service.UserApiService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import userApi.UserApiGrpc;

import static userApi.UserApiOuterClass.UserByClientCodeRequest;
import static userApi.UserApiOuterClass.UserResponse;

@Slf4j
@GRpcService
@RequiredArgsConstructor
public class UserApiGrpcService extends UserApiGrpc.UserApiImplBase {

    private final UserApiService userApiService;

    private final UserApiMapper userApiMapper;

    @Override
    public void getUserByClientCode(UserByClientCodeRequest request, StreamObserver<UserResponse> responseObserver) {
        if (request.getClientCode().isBlank()) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("Client code is blank").asRuntimeException());
        }

        responseObserver.onNext(getUserInfo(request, responseObserver));

        responseObserver.onCompleted();
    }

    private UserResponse getUserInfo(UserByClientCodeRequest request, StreamObserver<UserResponse> responseObserver) {
        try {
            return userApiMapper
                .from(userApiService
                    .getUserInfo(request.getClientCode()));
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.asRuntimeException());
            throw new IntegrationException(e.getMessage());
        }
    }
}
