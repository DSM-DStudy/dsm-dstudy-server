package com.example.dstudyserver.domain.admin.cotroller;

import com.example.dstudyserver.domain.admin.controller.dto.request.EntryRequest;
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

    @Test
    public void accept() throws Exception{
        boolean isAccept = true;

        EntryRequest request = new EntryRequest(isAccept);
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/admin/entry/1")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzQwODc5MiwiZXhwIjoxNjc3NDEyMzkyfQ.iG4__v_hT4wnLHdpCQt5P_yBRpGf6E9idPkODHfzghw")
        ).andExpect(status().isOk());
    }
}
