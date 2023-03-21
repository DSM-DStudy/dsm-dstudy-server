package com.example.dstudyserver.domain.tips.controller;

import com.example.dstudyserver.domain.tips.controller.dto.request.TipsRequest;
import com.example.dstudyserver.domain.tips.controller.dto.response.TipsResponse;
import com.example.dstudyserver.domain.tips.service.TipsService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TipsController {
    private final TipsService tipsService;

    @PostMapping("/tip")
    @Operation(summary = "꿀팁 게시판 글 저장")
    public TipsResponse save(@Valid @RequestBody TipsRequest request){
        return tipsService.save(request);
    }

    @DeleteMapping("/tip/{tip_id}")
    @Operation(summary = "꿀팁 게시판 글 삭제")
    public void delete(@PathVariable int tip_id){
        tipsService.delete(tip_id);
    }

    @GetMapping("/tip/{tip_id}")
    @Operation(summary = "꿀팁 게시판 글 보기")
    public TipsResponse getTips(@PathVariable int tip_id){
        return tipsService.getTips(tip_id);
    }

    @GetMapping("/tip/list")
    @Operation(summary = "꿀팁 게시판 글 리스트")
    public List<TipsResponse> tipsList(){
        return tipsService.tipsList();
    }

    @GetMapping("/tip")
    @Operation(summary = "꿀팁 게시판 검색")
    public List<TipsResponse> search(@RequestParam("keyword") String keyword){
        return tipsService.search(keyword);
    }
}
