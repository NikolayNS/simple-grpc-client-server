package com.dmitrenko.simplegrpcclientserver.service.impl;

import com.dmitrenko.simplegrpcclientserver.service.UserApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserApiServiceImplTest {

    @Autowired
    private UserApiService userApiService;

    @Test
    void getUserInfo() {
        var userResponse = userApiService.getUserResponse("1234");

        assertEquals("1889925524", userResponse.getPhone());
        assertEquals(3, userResponse.getGroupsList().size());
        System.out.println(userResponse);
    }
}