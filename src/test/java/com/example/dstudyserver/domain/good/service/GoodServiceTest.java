package com.example.dstudyserver.domain.good.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
public class GoodServiceTest {
    @Autowired
    private GoodService goodService;

    @BeforeEach
    public void setUser(){
        Authentication authentication = new UsernamePasswordAuthenticationToken("test@gmail.com", "", null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Test
    public void insertGood(){
        int studyId = 1;

        goodService.insertGood(studyId);
    }

    @Test
    public void deleteGood(){
        int studyId = 1;

        goodService.deleteGood(studyId);
    }
}
