package com.example.dstudyserver.domain.study.repository;

import com.example.dstudyserver.domain.study.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Integer> {
}
