package com.example.dstudyserver.domain.comment.controller;

import com.example.dstudyserver.domain.comment.controller.dto.request.CommentRequest;
import com.example.dstudyserver.domain.comment.controller.dto.response.CommentResponse;
import com.example.dstudyserver.domain.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{study_id}")
    @Operation(summary = "댓글 쓰기")
    public CommentResponse save(@Valid @RequestBody CommentRequest request, @PathVariable int study_id){
        return commentService.save(request, study_id);
    }

    @DeleteMapping("/comment/{comment_id}")
    @Operation(summary = "댓글 삭제")
    public void delete(@PathVariable int comment_id){
        commentService.delete(comment_id);
    }

    @GetMapping("/comment/list")
    @Operation(summary = "댓글 리스트")
    public List<CommentResponse> commentList(){
        return commentService.commentList();
    }
}
