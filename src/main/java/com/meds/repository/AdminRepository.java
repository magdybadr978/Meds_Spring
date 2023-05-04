package com.meds.repository;

import com.meds.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    public default List<Admin> findByName(String name) {
        return null;
    }
}
