package com.example.dstudyserver.domain.study.controller;

import com.example.dstudyserver.domain.study.controller.dto.request.StudyRequest;
import com.example.dstudyserver.domain.study.controller.dto.response.StudyResponse;
import com.example.dstudyserver.domain.study.service.StudyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @PostMapping("/study")
    public StudyResponse save(@Valid @RequestBody StudyRequest request) {
        return studyService.save(request);
    }

    @DeleteMapping("study/{study_id}")
    public void delete(@PathVariable int study_id){
        studyService.delete(study_id);
    }

    @GetMapping("/study/{study_id}")
    public StudyResponse getStudy(@PathVariable int study_id){
        return studyService.getStudy(study_id);
    }

    @GetMapping("/study/list")
    public List<StudyResponse> studyList(){
        return studyService.studyList();
    }

    @GetMapping("/study")
    public List<StudyResponse> search(@RequestParam("keyword") String keyword){
        return studyService.search(keyword);
    }

    @PatchMapping("/study/{study_id}")
    public void editStudy(@PathVariable int study_id, @Valid @RequestBody StudyRequest request){
        studyService.editStudy(study_id, request);
    }

}
