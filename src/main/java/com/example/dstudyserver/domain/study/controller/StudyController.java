package com.example.dstudyserver.domain.study.controller;

import com.example.dstudyserver.domain.study.controller.dto.request.StudyRequest;
import com.example.dstudyserver.domain.study.controller.dto.response.StudyResponse;
import com.example.dstudyserver.domain.study.service.StudyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @PostMapping("/study")
    @Operation(summary = "스터디 생성")
    public StudyResponse save(@Valid @RequestBody StudyRequest request) {
        return studyService.save(request);
    }

    @DeleteMapping("study/{study_id}")
    @Operation(summary = "스터디 삭제")
    public void delete(@PathVariable int study_id){
        studyService.delete(study_id);
    }

    @GetMapping("/study/{study_id}")
    @Operation(summary = "스터디 보기")
    public StudyResponse getStudy(@PathVariable int study_id){
        return studyService.getStudy(study_id);
    }

    @GetMapping("/study/list")
    @Operation(summary = "스터디 리스트")
    public List<StudyResponse> studyList(){
        return studyService.studyList();
    }

    @GetMapping("/study")
    @Operation(summary = "스터디 검색")
    public List<StudyResponse> search(@RequestParam("keyword") String keyword){
        return studyService.search(keyword);
    }

    @PatchMapping("/study/{study_id}")
    @Operation(summary = "스터디 수정")
    public void editStudy(@PathVariable int study_id, @Valid @RequestBody StudyRequest request){
        studyService.editStudy(study_id, request);
    }

}
