package com.example.dstudyserver.domain.user.service;

import com.example.dstudyserver.domain.user.controller.dto.request.SignupRequest;
import com.example.dstudyserver.domain.user.controller.dto.response.TokenResponse;
import com.example.dstudyserver.domain.user.entity.Role;
import com.example.dstudyserver.domain.user.entity.User;
import com.example.dstudyserver.domain.user.exception.AlreadyExistException;
import com.example.dstudyserver.domain.user.repository.UserRepository;
import com.example.dstudyserver.global.error.ErrorCode;
import com.example.dstudyserver.global.jwt.TokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public void signup(SignupRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent())
            throw new AlreadyExistException(ErrorCode.ALREADY_EXIST);

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .introduction(request.getIntroduction())
                .image(request.getImage())
                .student_id(request.getStudent_id())
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }
}
