package com.hr.repository;

import com.hr.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {
    public default List<Users> findByName(String name) {
        return null;
    }
}
