package com.example.dstudyserver.domain.tips.controller;

import com.example.dstudyserver.domain.tips.controller.dto.request.TipsRequest;
import com.example.dstudyserver.domain.tips.controller.dto.response.TipsResponse;
import com.example.dstudyserver.domain.tips.service.TipsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TipsController {
    private final TipsService tipsService;

    @PostMapping("/tip")
    public TipsResponse save(@RequestBody TipsRequest request){
        return tipsService.save(request);
    }

    @DeleteMapping("/tip/{tip_id}")
    public void delete(@PathVariable int tip_id){
        tipsService.delete(tip_id);
    }

    @GetMapping("/tip/{tip_id}")
    public TipsResponse getTips(@PathVariable int tip_id){
        return tipsService.getTips(tip_id);
    }

    @GetMapping("/tip/list")
    public List<TipsResponse> tipsList(){
        return tipsService.tipsList();
    }

    @GetMapping("/tip")
    public List<TipsResponse> search(@RequestParam("keyword") String keyword){
        return tipsService.search(keyword);
    }
}
