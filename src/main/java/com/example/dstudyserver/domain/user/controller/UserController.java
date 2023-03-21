package com.example.dstudyserver.domain.user.controller;

import com.example.dstudyserver.domain.user.controller.dto.request.EditProfileRequest;
import com.example.dstudyserver.domain.user.controller.dto.response.UserResponse;
import com.example.dstudyserver.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/mypage")
    @Operation(summary = "유저 정보 보기")
    public UserResponse getUser(){
        return userService.getUser();
    }

    @PatchMapping("/mypage")
    @Operation(summary = "프로필 수정")
    public void editProfile(@RequestBody EditProfileRequest request){
        userService.editProfile(request);
    }
}
