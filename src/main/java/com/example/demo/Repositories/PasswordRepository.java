package com.example.demo.Repositories;

import com.example.demo.Models.Password;
import com.example.demo.Models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PasswordRepository extends JpaRepository<Password, Long> {
    ArrayList<Password> findAllByAuthorUID (String authorUID);
    Password findById (long id);
}
