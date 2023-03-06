package com.example.dstudyserver.domain.tip.service;

import com.example.dstudyserver.domain.tips.controller.dto.request.TipsRequest;
import com.example.dstudyserver.domain.tips.controller.dto.response.TipsResponse;
import com.example.dstudyserver.domain.tips.repository.TipsRepository;
import com.example.dstudyserver.domain.tips.service.TipsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@SpringBootTest
public class TipServiceTest {
    @Autowired
    private TipsService tipsService;

    @Autowired
    private TipsRepository tipsRepository;

    @BeforeEach
    public void setUser(){
        UserAuthentication userAuthentication = new UserAuthentication("test@gmail.com", null, null);
        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
    }

    @Test
    public void save(){
        String title = "study tips";
        String content = "fake lol";

        TipsRequest request = new TipsRequest(title, content);

        TipsResponse response = tipsService.save(request);

        Assertions.assertEquals(response.getTitle(), title);
        Assertions.assertEquals(response.getContent(), content);
    }

    @Test
    public void delete(){
        int tips_id = 1;

        tipsService.delete(tips_id);

        Assertions.assertTrue(tipsRepository.findById(tips_id).isEmpty());
    }

    @Test
    public void getTips(){
        int tips_id = 2;

        TipsResponse response = tipsService.getTips(tips_id);

        Assertions.assertEquals(response.getId(), tips_id);
    }

    @Test
    public void tipsList(){
        List<TipsResponse> tipsList = tipsService.tipsList();

        Assertions.assertEquals(tipsList.size(), 1);
    }

    @Test
    public void search(){
        String keyword = "study";

        List<TipsResponse> tipsList = tipsService.search(keyword);

        Assertions.assertEquals(tipsList.size(), 1);
    }

}
