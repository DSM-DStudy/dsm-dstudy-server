package com.example.dstudyserver.domain.join.service;

import com.example.dstudyserver.domain.join.entity.Entry;
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

@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;
    private final StudyRepository studyRepository;

    @Transactional
    public void join(int study_id){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Study study = studyRepository.findById(study_id).orElseThrow(StudyNotFoundException::new);
        Entry entry = Entry.builder()
                .user(user)
                .study(study)
                .build();
    }
}
