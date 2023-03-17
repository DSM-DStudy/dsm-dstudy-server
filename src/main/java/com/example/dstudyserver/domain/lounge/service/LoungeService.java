package com.example.dstudyserver.domain.lounge.service;

import com.example.dstudyserver.domain.lounge.controller.dto.request.LoungeRequest;
import com.example.dstudyserver.domain.lounge.controller.dto.response.LoungeResponse;
import com.example.dstudyserver.domain.lounge.entity.Lounge;
import com.example.dstudyserver.domain.lounge.exception.LoungeNotFoundException;
import com.example.dstudyserver.domain.lounge.repository.LoungeRepository;
import com.example.dstudyserver.domain.user.entity.User;
import com.example.dstudyserver.domain.user.exception.UserNotFoundException;
import com.example.dstudyserver.domain.user.repository.UserRepository;
import com.example.dstudyserver.global.security.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoungeService {
    private final LoungeRepository loungeRepository;
    private final UserRepository userRepository;

    @Transactional
    public LoungeResponse save(LoungeRequest request){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Lounge lounge = Lounge.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .build();

        loungeRepository.save(lounge);

        return LoungeResponse.builder()
                .id(lounge.getId())
                .title(lounge.getTitle())
                .content(lounge.getContent())
                .user(lounge.getUser())
                .build();
    }

    @Transactional
    public void delete(int lounge_id){
        loungeRepository.deleteById(lounge_id);
    }

    @Transactional
    public LoungeResponse getLounge(int lounge_id){
        Lounge lounge = loungeRepository.findById(lounge_id).orElseThrow(LoungeNotFoundException::new);
        return LoungeResponse.builder()
                .id(lounge.getId())
                .title(lounge.getTitle())
                .content(lounge.getContent())
                .user(lounge.getUser())
                .build();
    }

    @Transactional
    public List<LoungeResponse> loungeList(){
        List<Lounge> lounges = loungeRepository.findAll();
        return lounges.stream().map(p -> new LoungeResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getUser())).collect(Collectors.toList());
    }

    @Transactional
    public List<LoungeResponse> search(String keyword){
        List<Lounge> lounges = loungeRepository.findByTitleContaining(keyword);
        return lounges.stream().map(p -> new LoungeResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getUser())).collect(Collectors.toList());
    }
}
