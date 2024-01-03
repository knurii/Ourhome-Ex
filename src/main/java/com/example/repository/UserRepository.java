package com.example.repository;

import com.example.domain.dto.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByUsername(String username); //있으면 값 들어오고 아니면 안들어옴
}
