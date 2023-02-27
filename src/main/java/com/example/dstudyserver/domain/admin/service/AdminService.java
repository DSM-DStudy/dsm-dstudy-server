package com.example.dstudyserver.domain.admin.service;

import com.example.dstudyserver.domain.admin.controller.dto.request.UserRequest;
import com.example.dstudyserver.domain.admin.controller.dto.response.EntryResponse;
import com.example.dstudyserver.domain.admin.controller.dto.response.UserResponse;
import com.example.dstudyserver.domain.admin.exception.EntryNotFoundException;
import com.example.dstudyserver.domain.join.entity.Entry;
import com.example.dstudyserver.domain.join.repository.EntryRepository;
import com.example.dstudyserver.domain.study.entity.Study;
import com.example.dstudyserver.domain.study.repository.StudyRepository;
import com.example.dstudyserver.domain.user.entity.User;
import com.example.dstudyserver.domain.user.exception.UserNotFoundException;
import com.example.dstudyserver.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final EntryRepository entryRepository;
    private final UserRepository userRepository;
    private final StudyRepository studyRepository;
    private final PasswordEncoder passwordEncoder;

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
            entryRepository.delete(entry);
        }
    }

    @Transactional
    public List<UserResponse> userList(){
        List<User> userList = userRepository.findAll();
        return userList.stream().map(u -> new UserResponse(
                u.getId(),
                u.getEmail()
        )).collect(Collectors.toList());
    }

    @Transactional
    public void editUser(UserRequest request){
        User user = userRepository.findById(request.getId()).orElseThrow(UserNotFoundException::new);
        user.editUser(request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getId());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(int user_id){
        userRepository.deleteById(user_id);
    }

    @Transactional
    public void withdrawal(int user_id){
        User user = userRepository.findById(user_id).orElseThrow(UserNotFoundException::new);
        user.setStudy(null);
        userRepository.save(user);
    }
}
