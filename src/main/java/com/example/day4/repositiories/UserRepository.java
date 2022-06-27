package com.example.day4.repositiories;

import com.example.day4.entities.Spid;
import com.example.day4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    Optional<User> findById (Long id);
}
