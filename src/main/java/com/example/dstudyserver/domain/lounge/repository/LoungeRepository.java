package com.example.dstudyserver.domain.lounge.repository;

import com.example.dstudyserver.domain.lounge.entity.Lounge;
import com.example.dstudyserver.domain.tips.entity.Tips;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoungeRepository extends JpaRepository <Lounge, Integer> {
    List<Lounge> findByTitleContaining(String keyword);
}
