package com.example.dstudyserver.domain.token.repository;

import com.example.dstudyserver.domain.token.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
