package com.example.dstudyserver.domain.good.repository;

import com.example.dstudyserver.domain.good.entity.Good;
import com.example.dstudyserver.domain.study.entity.Study;
import com.example.dstudyserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodRepository extends JpaRepository<Good, Integer> {
    Optional<Good> findByUserAndStudy(User user, Study study);
}
