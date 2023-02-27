package com.example.dstudyserver.domain.admin.service;

import com.example.dstudyserver.domain.admin.controller.dto.request.UserRequest;
import com.example.dstudyserver.domain.admin.controller.dto.response.EntryResponse;
import com.example.dstudyserver.domain.admin.controller.dto.response.UserResponse;
import com.example.dstudyserver.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void entryList(){
        List<EntryResponse> list = adminService.entryList();

        Assertions.assertEquals(list.size(), 0);
    }

    @Test
    public void accept(){
        boolean accept = true;
        int entry_id = 1;

        adminService.accept(accept, entry_id);
    }

    @Test
    public void userList(){
        List<UserResponse> list = adminService.userList();

        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    public void editUser(){
        int id = 1;
        String email = "test@gmail.com";
        String password = "1234";
        int student_id = 3000;

        UserRequest request = new UserRequest(id, email, password, student_id);
        adminService.editUser(request);
    }

    @Test
    public void deleteUser(){
        int user_id = 2;

        adminService.deleteUser(user_id);

        Assertions.assertTrue(userRepository.findById(user_id).isEmpty());
    }

    @Test
    public void secession(){
        int user_id = 1;

        adminService.secession(user_id);
    }
}
