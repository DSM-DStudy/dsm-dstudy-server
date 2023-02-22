package com.example.dstudyserver.domain.admin.controller;

import com.example.dstudyserver.domain.admin.controller.dto.request.EntryRequest;
import com.example.dstudyserver.domain.admin.controller.dto.request.UserRequest;
import com.example.dstudyserver.domain.admin.controller.dto.response.EntryResponse;
import com.example.dstudyserver.domain.admin.controller.dto.response.UserResponse;
import com.example.dstudyserver.domain.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admin/entry/list")
    public List<EntryResponse> entryList(){
        return adminService.entryList();
    }

    @PostMapping("/admin/entry/{entry_id}")
    public void accept(@RequestBody EntryRequest request, @PathVariable int entry_id){
        adminService.accept(request.isAccept(), entry_id);
    }

    @GetMapping("/admin/user/list")
    public List<UserResponse> userList(){
        return adminService.userList();
    }

    @PatchMapping("/admin/user")
    public void editUser(@RequestBody UserRequest request){
        adminService.editUser(request);
    }

    @DeleteMapping("/admin/user/{user_id}")
    public void deleteUser(@PathVariable int user_id){
        adminService.deleteUser(user_id);
    }

    @DeleteMapping("/admin/study/{user_id}")
    public void withdrawal(@PathVariable int user_id){
        adminService.withdrawal(user_id);
    }
}
