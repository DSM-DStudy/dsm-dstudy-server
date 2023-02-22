package com.example.dstudyserver.domain.tips.service;

import com.example.dstudyserver.domain.tips.controller.dto.request.TipsRequest;
import com.example.dstudyserver.domain.tips.controller.dto.response.TipsResponse;
import com.example.dstudyserver.domain.tips.entity.Tips;
import com.example.dstudyserver.domain.tips.exception.TipsNotFoundException;
import com.example.dstudyserver.domain.tips.repository.TipsRepository;
import com.example.dstudyserver.domain.user.entity.User;
import com.example.dstudyserver.domain.user.exception.UserNotFoundException;
import com.example.dstudyserver.domain.user.repository.UserRepository;
import com.example.dstudyserver.global.utils.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipsService {
    private final TipsRepository tipsRepository;
    private final UserRepository userRepository;

    @Transactional
    public TipsResponse save(TipsRequest request){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Tips tips = Tips.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .build();

        tipsRepository.save(tips);

        return TipsResponse.builder()
                .id(tips.getId())
                .title(tips.getTitle())
                .content(tips.getContent())
                .user(tips.getUser())
                .build();
    }

    @Transactional
    public void delete(int tips_id){
        tipsRepository.deleteById(tips_id);
    }

    @Transactional
    public TipsResponse getTips(int tips_id){
        Tips tips = tipsRepository.findById(tips_id).orElseThrow(TipsNotFoundException::new);
        return TipsResponse.builder()
                .id(tips.getId())
                .title(tips.getTitle())
                .content(tips.getContent())
                .user(tips.getUser())
                .build();
    }

    @Transactional
    public List<TipsResponse> tipsList(){
        List<Tips> tips = tipsRepository.findAll();
        return tips.stream().map(p -> new TipsResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getUser())).collect(Collectors.toList());
    }

    @Transactional
    public List<TipsResponse> search(String keyword){
        List<Tips> tips = tipsRepository.findByTitleContaining(keyword);
        return tips.stream().map(p -> new TipsResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getUser())).collect(Collectors.toList());
    }
}
