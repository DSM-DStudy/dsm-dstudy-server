package com.example.dstudyserver.domain.lounge.repository;

import com.example.dstudyserver.domain.lounge.entity.Lounge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoungeRepository extends JpaRepository <Lounge, Integer> {
}
