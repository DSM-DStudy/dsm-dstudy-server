package com.example.dstudyserver.domain.user.service;

import com.example.dstudyserver.domain.user.controller.dto.request.LoginRequest;
import com.example.dstudyserver.domain.user.controller.dto.request.SignupRequest;
import com.example.dstudyserver.domain.user.controller.dto.response.TokenResponse;
import com.example.dstudyserver.domain.user.entity.Role;
import com.example.dstudyserver.domain.user.entity.User;
import com.example.dstudyserver.domain.user.exception.AlreadyExistException;
import com.example.dstudyserver.domain.user.exception.PasswordNotMatchesException;
import com.example.dstudyserver.domain.user.exception.UserNotFoundException;
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
            throw new AlreadyExistException();

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .introduction(request.getIntroduction())
                .image(request.getImage())
                .student_id(request.getStudent_id())
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);
    }

    @Transactional
    public TokenResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(UserNotFoundException::new);
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new PasswordNotMatchesException();

        String access = tokenProvider.createAccessToken(request.getEmail());
        String refresh = tokenProvider.createRefreshToken(request.getEmail());

        return TokenResponse.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .build();
    }
}
