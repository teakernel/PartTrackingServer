package com.auto.warehouse.partserver.repository;

import com.auto.warehouse.partserver.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByName(String name);
}
