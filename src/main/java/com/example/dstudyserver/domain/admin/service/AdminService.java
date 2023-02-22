package com.example.dstudyserver.domain.admin.service;

import com.example.dstudyserver.domain.admin.controller.dto.response.EntryResponse;
import com.example.dstudyserver.domain.admin.exception.EntryNotFoundException;
import com.example.dstudyserver.domain.join.entity.Entry;
import com.example.dstudyserver.domain.join.repository.EntryRepository;
import com.example.dstudyserver.domain.study.entity.Study;
import com.example.dstudyserver.domain.study.repository.StudyRepository;
import com.example.dstudyserver.domain.user.entity.User;
import com.example.dstudyserver.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final EntryRepository entryRepository;
    private final UserRepository userRepository;
    private final StudyRepository studyRepository;

    @Transactional
    public List<EntryResponse> entryList(){
        List<Entry> entryList = entryRepository.findAll();
        return entryList.stream().map(e -> new EntryResponse(
                e.getId(),
                e.getUser(),
                e.getStudy()
        )).collect(Collectors.toList());
    }

    @Transactional
    public void accept(boolean accept, int entry_id){
        Entry entry = entryRepository.findById(entry_id).orElseThrow(EntryNotFoundException::new);
        User user = entry.getUser();
        Study study = entry.getStudy();

        if(accept){
            user.setStudy(study);
            study.getUserList().add(user);

            userRepository.save(user);
            studyRepository.save(study);
        }
    }
}
