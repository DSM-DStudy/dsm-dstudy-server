package com.example.dstudyserver.domain.comment.repository;

import com.example.dstudyserver.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
