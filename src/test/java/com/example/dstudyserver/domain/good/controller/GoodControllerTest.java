package com.example.dstudyserver.domain.good.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GoodControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void insertGood() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.post("/like/1")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QWRtaW5AZ21haWwuY29tIiwicm9sZSI6IlJPTEVfQURNSU4iLCJpYXQiOjE2Nzg5NTM5NjgsImV4cCI6MTY3ODk1NzU2OH0.f9ciKDMDP-PdYpsbtSz4mcAsfcUnse2kOOA3NgUHWi0")
        ).andExpect(status().isOk());
    }

    @Test
    public void deleteGood() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/like/1")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QWRtaW5AZ21haWwuY29tIiwicm9sZSI6IlJPTEVfQURNSU4iLCJpYXQiOjE2Nzg5NTM5NjgsImV4cCI6MTY3ODk1NzU2OH0.f9ciKDMDP-PdYpsbtSz4mcAsfcUnse2kOOA3NgUHWi0")
        ).andExpect(status().isOk());
    }
}
