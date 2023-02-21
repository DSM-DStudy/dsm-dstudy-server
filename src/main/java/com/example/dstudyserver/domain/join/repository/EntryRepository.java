package com.example.dstudyserver.domain.join.repository;

import com.example.dstudyserver.domain.join.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository <Entry, Integer> {
}
