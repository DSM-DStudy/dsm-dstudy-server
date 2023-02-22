package com.example.dstudyserver.domain.user.controller;

import com.example.dstudyserver.domain.user.controller.dto.request.EditProfileRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getUser() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/mypage")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzA2NjE2MSwiZXhwIjoxNjc3MDY5NzYxfQ.6XIlUqaZI0zh8ARJX82Tzk491wuT9Ps1QACUPurkNFU")
        ).andExpect(status().isOk());
    }

    @Test
    public void editProfile() throws Exception{
        String introduction = "abcdefg";
        String image = "asdfafasfaasfasfsadfsafasf";

        EditProfileRequest request = new EditProfileRequest(introduction, image);
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/mypage")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzA2NjE2MSwiZXhwIjoxNjc3MDY5NzYxfQ.6XIlUqaZI0zh8ARJX82Tzk491wuT9Ps1QACUPurkNFU")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

    }
}
