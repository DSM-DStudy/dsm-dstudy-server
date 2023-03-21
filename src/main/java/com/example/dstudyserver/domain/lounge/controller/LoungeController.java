package com.example.dstudyserver.domain.lounge.controller;

import com.example.dstudyserver.domain.lounge.controller.dto.request.LoungeRequest;
import com.example.dstudyserver.domain.lounge.controller.dto.response.LoungeResponse;
import com.example.dstudyserver.domain.lounge.service.LoungeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoungeController {

    private final LoungeService loungeService;
    @PostMapping("/lounge")
    @Operation(summary = "라운지 글쓰기")
    public LoungeResponse save(@Valid @RequestBody LoungeRequest request){
        return loungeService.save(request);
    }

    @DeleteMapping("/lounge/{lounge_id}")
    @Operation(summary = "라운지 삭제")
    public void delete(@PathVariable int lounge_id){
        loungeService.delete(lounge_id);
    }

    @GetMapping("/lounge/{lounge_id}")
    @Operation(summary = "라운지 보기")
    public LoungeResponse getLounge(@PathVariable int lounge_id){
        return loungeService.getLounge(lounge_id);
    }

    @GetMapping("/lounge/list")
    @Operation(summary = "라운지 리스트")
    public List<LoungeResponse> loungeList(){
        return loungeService.loungeList();
    }

    @GetMapping("/lounge")
    @Operation(summary = "라운지 검색")
    public List<LoungeResponse> search(@RequestParam("keyword") String keyword){
        return loungeService.search(keyword);
    }

}
