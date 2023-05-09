package com.meds.repository;

import com.meds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByName(String name);


    // Check this Admin or not
    @Query(value = "select * from users user where user.id = ?1 and user.type=1",
            nativeQuery = true
    )
    public Optional<User> isAdmin(long id);

    public boolean existsUserById(long id);


}
