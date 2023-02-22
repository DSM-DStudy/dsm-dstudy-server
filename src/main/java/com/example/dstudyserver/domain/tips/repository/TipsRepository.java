package com.example.dstudyserver.domain.tips.repository;

import com.example.dstudyserver.domain.tips.entity.Tips;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipsRepository extends JpaRepository <Tips, Integer> {
    List<Tips> findByTitleContaining(String keyword);
}
