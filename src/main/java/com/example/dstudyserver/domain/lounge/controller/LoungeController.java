package com.example.dstudyserver.domain.lounge.controller;

import com.example.dstudyserver.domain.lounge.controller.dto.request.LoungeRequest;
import com.example.dstudyserver.domain.lounge.controller.dto.response.LoungeResponse;
import com.example.dstudyserver.domain.lounge.service.LoungeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoungeController {

    private final LoungeService loungeService;
    @PostMapping("/lounge")
    public LoungeResponse save(@Valid @RequestBody LoungeRequest request){
        return loungeService.save(request);
    }

    @DeleteMapping("/lounge/{lounge_id}")
    public void delete(@PathVariable int lounge_id){
        loungeService.delete(lounge_id);
    }

    @GetMapping("/lounge/{lounge_id}")
    public LoungeResponse getLounge(@PathVariable int lounge_id){
        return loungeService.getLounge(lounge_id);
    }

    @GetMapping("/lounge/list")
    public List<LoungeResponse> loungeList(){
        return loungeService.loungeList();
    }

    @GetMapping("/lounge")
    public List<LoungeResponse> search(@RequestParam("keyword") String keyword){
        return loungeService.search(keyword);
    }

}
