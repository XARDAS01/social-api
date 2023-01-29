package com.example.demo.Repositories;

import com.example.demo.Models.Token;
import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken (String token);
    Token findByUid (String uid);
}
