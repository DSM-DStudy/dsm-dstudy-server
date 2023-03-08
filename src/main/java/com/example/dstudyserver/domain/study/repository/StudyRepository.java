package com.example.dstudyserver.domain.study.repository;

import com.example.dstudyserver.domain.study.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Integer> {
    List<Study> findByTitleContaining(String keyword);
}
