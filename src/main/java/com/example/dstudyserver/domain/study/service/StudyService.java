package com.example.dstudyserver.domain.study.service;

import com.example.dstudyserver.domain.study.controller.dto.request.EditStudyRequest;
import com.example.dstudyserver.domain.study.controller.dto.request.StudyRequest;
import com.example.dstudyserver.domain.study.controller.dto.response.StudyResponse;
import com.example.dstudyserver.domain.study.entity.Study;
import com.example.dstudyserver.domain.study.exception.StudyNotFoundException;
import com.example.dstudyserver.domain.study.repository.StudyRepository;
import com.example.dstudyserver.domain.user.entity.User;
import com.example.dstudyserver.domain.user.exception.UserNotFoundException;
import com.example.dstudyserver.domain.user.repository.UserRepository;
import com.example.dstudyserver.global.security.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final UserRepository userRepository;
    private final StudyRepository studyRepository;

    @Transactional
    public StudyResponse save(StudyRequest request){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Study study = Study.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .field(request.getField())
                .study_time(request.getStudy_time())
                .study_image(request.getStudy_image())
                .memo(request.getMemo())
                .user(user)
                .build();

        studyRepository.save(study);

        return StudyResponse.builder()
                .id(study.getId())
                .title(study.getTitle())
                .people_count(study.getPeople_count())
                .content(study.getContent())
                .field(study.getField())
                .study_time(study.getStudy_time())
                .study_image(study.getStudy_image())
                .like_count(study.getLike_count())
                .memo(study.getMemo())
                .creater(study.getCreater())
                .user(study.getUser())
                .build();
    }

    @Transactional
    public void delete(int study_id){
        studyRepository.deleteById(study_id);
    }

    @Transactional
    public StudyResponse getStudy(int study_id){
        Study study = studyRepository.findById(study_id).orElseThrow(StudyNotFoundException::new);
        return StudyResponse.builder()
                .id(study.getId())
                .title(study.getTitle())
                .content(study.getContent())
                .field(study.getField())
                .study_time(study.getStudy_time())
                .study_image(study.getStudy_image())
                .memo(study.getMemo())
                .like_count(study.getLike_count())
                .people_count(study.getPeople_count())
                .creater(study.getCreater())
                .user(study.getUser())
                .build();
    }

    @Transactional
    public List<StudyResponse> studyList(){
        List<Study> study = studyRepository.findAll();
        return study.stream().map(p -> new StudyResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getField(),
                p.getStudy_time(),
                p.getStudy_image(),
                p.getMemo(),
                p.getLike_count(),
                p.getPeople_count(),
                p.getCreater(),
                p.getUser())).collect(Collectors.toList());
    }

    @Transactional
    public List<StudyResponse> search(String keyword){
        List<Study> study = studyRepository.findByTitleContaining(keyword);
        return study.stream().map(p -> new StudyResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getField(),
                p.getStudy_time(),
                p.getStudy_image(),
                p.getMemo(),
                p.getLike_count(),
                p.getPeople_count(),
                p.getCreater(),
                p.getUser())).collect(Collectors.toList());
    }

    @Transactional
    public void editStudy(int study_id, EditStudyRequest request){
        Study study = studyRepository.findById(study_id).orElseThrow(StudyNotFoundException::new);
        study.editStudy(request.getTitle(), request.getContent(), request.getField(), request.getStudy_time(), request.getStudy_image(), request.getMemo());
        studyRepository.save(study);
    }

}
