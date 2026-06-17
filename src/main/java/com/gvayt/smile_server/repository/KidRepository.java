package com.gvayt.smile_server.repository;

import com.gvayt.smile_server.entity.Kid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KidRepository extends JpaRepository<Kid, Long> {
    Optional<Kid> findByLogin(String login);
    boolean existsByLoginAndParentId(String login, Long parent_id);
}
