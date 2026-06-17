package com.gvayt.smile_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gvayt.smile_server.entity.Parent;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long>{
    Optional<Parent> findByEmail(String email);
}
