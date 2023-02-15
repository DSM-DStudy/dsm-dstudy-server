package com.example.dstudyserver.domain.recommend.repository;

import com.example.dstudyserver.domain.recommend.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepository extends JpaRepository <Recommend, Integer> {
}
