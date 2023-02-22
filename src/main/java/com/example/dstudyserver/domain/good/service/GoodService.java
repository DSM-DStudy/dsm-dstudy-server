package com.example.dstudyserver.domain.good.service;

import com.example.dstudyserver.domain.good.entity.Good;
import com.example.dstudyserver.domain.good.exception.GoodConflictException;
import com.example.dstudyserver.domain.good.repository.GoodRepository;
import com.example.dstudyserver.domain.study.entity.Study;
import com.example.dstudyserver.domain.study.exception.StudyNotFoundException;
import com.example.dstudyserver.domain.study.repository.StudyRepository;
import com.example.dstudyserver.domain.user.entity.User;
import com.example.dstudyserver.domain.user.exception.UserNotFoundException;
import com.example.dstudyserver.domain.user.repository.UserRepository;
import com.example.dstudyserver.global.utils.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodService {
    private final UserRepository userRepository;
    private final StudyRepository studyRepository;
    private final GoodRepository goodRepository;

    private boolean isNotAlreadyGood(Study study, User user){
        return goodRepository.findByUserAndStudy(user, study).isEmpty();
    }

    @Transactional
    public void insertGood(int studyId){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Study study = studyRepository.findById(studyId).orElseThrow(StudyNotFoundException::new);
        Good good = Good.builder()
                .user(user)
                .study(study)
                .build();

        if(isNotAlreadyGood(study, user)){
            goodRepository.save(good);
            study.setGoodCount(study.getLike_count() + 1);
            studyRepository.save(study);
        }
        else {
            throw new GoodConflictException();
        }
    }
}
