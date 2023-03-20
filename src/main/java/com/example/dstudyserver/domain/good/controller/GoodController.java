package com.example.dstudyserver.domain.good.controller;

import com.example.dstudyserver.domain.good.service.GoodService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoodController {
    private final GoodService goodService;

    @PostMapping("/like/{study_id}")
    @Operation(summary = "좋아요 추가")
    public void insertGood(@PathVariable int study_id){
        goodService.insertGood(study_id);
    }

    @DeleteMapping("/like/{study_id}")
    @Operation(summary = "좋아요 삭제")
    public void deleteGood(@PathVariable int study_id){
        goodService.deleteGood(study_id);
    }
}
