package com.example.dstudyserver.domain.tip.controller;

import com.example.dstudyserver.domain.tips.controller.dto.request.TipsRequest;
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
public class TipControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void save() throws Exception{
        String title = "abc";
        String content = "def";

        TipsRequest request = new TipsRequest(title, content);
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/tip")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzA2NjE2MSwiZXhwIjoxNjc3MDY5NzYxfQ.6XIlUqaZI0zh8ARJX82Tzk491wuT9Ps1QACUPurkNFU")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/tip/3")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzA2NjE2MSwiZXhwIjoxNjc3MDY5NzYxfQ.6XIlUqaZI0zh8ARJX82Tzk491wuT9Ps1QACUPurkNFU")

        ).andExpect(status().isOk());
    }

    @Test
    public void getTip() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/tip/2")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzA2NjE2MSwiZXhwIjoxNjc3MDY5NzYxfQ.6XIlUqaZI0zh8ARJX82Tzk491wuT9Ps1QACUPurkNFU")

        ).andExpect(status().isOk());
    }

    @Test
    public void tipList() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/tip/list")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzA2NjE2MSwiZXhwIjoxNjc3MDY5NzYxfQ.6XIlUqaZI0zh8ARJX82Tzk491wuT9Ps1QACUPurkNFU")

        ).andExpect(status().isOk());
    }

    @Test
    public void search() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/tip?keyword=study")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzA2NjE2MSwiZXhwIjoxNjc3MDY5NzYxfQ.6XIlUqaZI0zh8ARJX82Tzk491wuT9Ps1QACUPurkNFU")

        ).andExpect(status().isOk());
    }
}
