package com.example.dstudyserver.domain.comment.service;


import com.example.dstudyserver.domain.comment.controller.dto.request.CommentRequest;
import com.example.dstudyserver.domain.comment.controller.dto.response.CommentResponse;
import com.example.dstudyserver.domain.comment.entity.Comment;
import com.example.dstudyserver.domain.comment.repository.CommentRepository;
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
public class CommentService {

    private final CommentRepository commentRepository;
    private final StudyRepository studyRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponse save(CommentRequest request, int study_id){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Study study = studyRepository.findById(study_id).orElseThrow(StudyNotFoundException::new);
        Comment comment = Comment.builder()
                .content(request.getContent())
                .user(user)
                .study(study)
                .build();

        commentRepository.save(comment);

        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .user(comment.getUser())
                .study(comment.getStudy())
                .build();
    }

    @Transactional
    public void delete(int comment_id){
        commentRepository.deleteById(comment_id);
    }

    @Transactional
    public List<CommentResponse> commentList(){
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(p -> new CommentResponse(
                p.getId(),
                p.getContent(),
                p.getUser(),
                p.getStudy())).collect(Collectors.toList());
    }

}
