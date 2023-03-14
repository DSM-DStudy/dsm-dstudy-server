package com.example.dstudyserver.domain.user.service;

import com.example.dstudyserver.domain.user.controller.dto.request.EditProfileRequest;
import com.example.dstudyserver.domain.user.controller.dto.response.UserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUser(){
        Authentication authentication = new UsernamePasswordAuthenticationToken("test@gmail.com", "", null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Test
    public void getUser(){
        UserResponse userResponse = userService.getUser();

        Assertions.assertEquals(userResponse.getEmail(), "test@gmail.com");
    }

    @Test
    public void editUser(){
        String introduction = "hi i'm a";
        String image = "asdfafdsafasdfaasf";
        EditProfileRequest request = new EditProfileRequest(introduction, image);

        userService.editProfile(request);
    }
}
