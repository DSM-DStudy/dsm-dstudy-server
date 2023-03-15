package com.example.dstudyserver.domain.comment.controller;

import com.example.dstudyserver.domain.comment.controller.dto.request.CommentRequest;
import com.example.dstudyserver.domain.comment.controller.dto.response.CommentResponse;
import com.example.dstudyserver.domain.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{study_id}")
    public CommentResponse save(@Valid @RequestBody CommentRequest request, @PathVariable int study_id){
        return commentService.save(request, study_id);
    }

    @DeleteMapping("/comment/{comment_id}")
    public void delete(@PathVariable int comment_id){
        commentService.delete(comment_id);
    }

    @GetMapping("/comment/list")
    public List<CommentResponse> commentList(){
        return commentService.commentList();
    }
}
