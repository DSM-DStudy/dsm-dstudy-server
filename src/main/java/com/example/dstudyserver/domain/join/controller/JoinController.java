package com.example.dstudyserver.domain.join.controller;

import com.example.dstudyserver.domain.join.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/study/join/{study_id}")
    public void join(@PathVariable int study_id){
        joinService.join(study_id);
    }
}
