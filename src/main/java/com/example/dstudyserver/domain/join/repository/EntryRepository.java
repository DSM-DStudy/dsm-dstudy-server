package com.example.dstudyserver.domain.join.repository;

import com.example.dstudyserver.domain.join.entity.Entry;
import com.example.dstudyserver.domain.study.entity.Study;
import com.example.dstudyserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntryRepository extends JpaRepository <Entry, Integer> {
    Optional<Entry> findByUserAndStudy(User user, Study study);
}
