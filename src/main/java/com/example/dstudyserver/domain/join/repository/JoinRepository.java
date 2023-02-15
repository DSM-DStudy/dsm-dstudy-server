package com.example.dstudyserver.domain.join.repository;

import com.example.dstudyserver.domain.join.entity.Join;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinRepository extends JpaRepository <Join, Integer> {
}
