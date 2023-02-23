package com.example.dstudyserver.domain.admin.service;

import com.example.dstudyserver.domain.admin.controller.dto.response.EntryResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void entryList(){
        List<EntryResponse> list = adminService.entryList();

        Assertions.assertEquals(list.size(), 0);
    }
    
}
