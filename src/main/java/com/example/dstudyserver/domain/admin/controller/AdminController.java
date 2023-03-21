package com.example.dstudyserver.domain.admin.controller;

import com.example.dstudyserver.domain.admin.controller.dto.request.AdminRequest;
import com.example.dstudyserver.domain.admin.controller.dto.request.EntryRequest;
import com.example.dstudyserver.domain.admin.controller.dto.request.UserRequest;
import com.example.dstudyserver.domain.admin.controller.dto.response.EntryResponse;
import com.example.dstudyserver.domain.admin.controller.dto.response.UserResponse;
import com.example.dstudyserver.domain.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admin/entry/list")
    @Operation(summary = "스터디 가입 신청 리스트")
    public List<EntryResponse> entryList(){
        return adminService.entryList();
    }

    @PostMapping("/admin/entry/{entry_id}")
    @Operation(summary = "스터디 가입 신청 수락")
    public void accept(@RequestBody @Valid EntryRequest request, @PathVariable int entry_id){
        adminService.accept(request.isAccept(), entry_id);
    }

    @GetMapping("/admin/user/list")
    @Operation(summary = "유저 리스트")
    public List<UserResponse> userList(){
        return adminService.userList();
    }

    @PatchMapping("/admin/user")
    @Operation(summary = "유저 정보 수정")
    public void editUser(@RequestBody @Valid UserRequest request){
        adminService.editUser(request);
    }

    @DeleteMapping("/admin/user/{user_id}")
    @Operation(summary = "유저 삭제")
    public void deleteUser(@PathVariable int user_id){
        adminService.deleteUser(user_id);
    }

    @DeleteMapping("/admin/study/{user_id}")
    @Operation(summary = "스터디 탈퇴")
    public void secession(@PathVariable int user_id){
        adminService.secession(user_id);
    }

    @PostMapping("/admin")
    @Operation(summary = "어드민 계정 생성")
    public void createAdmin(@RequestBody @Valid AdminRequest request){
        adminService.createAdmin(request);
    }
}
