package com.example.dstudyserver.domain.user.service;

import com.example.dstudyserver.domain.user.controller.dto.request.EditProfileRequest;
import com.example.dstudyserver.domain.user.controller.dto.response.UserResponse;
import com.example.dstudyserver.domain.user.entity.User;
import com.example.dstudyserver.domain.user.exception.UserNotFoundException;
import com.example.dstudyserver.domain.user.repository.UserRepository;
import com.example.dstudyserver.global.utils.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse getUser(){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        return UserResponse.builder()
                .email(user.getEmail())
                .introduction(user.getIntroduction())
                .student_id(user.getStudent_id())
                .image(user.getImage())
                .study(user.getStudy())
                .goodList(user.getGoodList())
                .build();
    }

    @Transactional
    public void editProfile(EditProfileRequest request){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        user.editProfile(request.getIntroduction(), request.getImage());
        userRepository.save(user);
    }
}
