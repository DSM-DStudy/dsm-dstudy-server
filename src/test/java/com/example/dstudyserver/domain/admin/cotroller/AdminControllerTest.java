package com.example.dstudyserver.domain.admin.cotroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void entryList() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/entry/list")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzMyOTgwMCwiZXhwIjoxNjc3MzMzNDAwfQ.LUoh4Ao6S8ijDs3LKrHk7nRRIwdGBZYJBJFNnOc_uUI")

        ).andExpect(status().isOk());
    }
}
