package com.example.dstudyserver.domain.good.repository;

import com.example.dstudyserver.domain.good.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, Integer> {
}
