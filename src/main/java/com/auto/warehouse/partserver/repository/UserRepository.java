package com.auto.warehouse.partserver.repository;

import com.auto.warehouse.partserver.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
