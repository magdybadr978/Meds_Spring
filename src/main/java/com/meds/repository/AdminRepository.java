package com.meds.repository;

import com.meds.model.Admin;
import com.meds.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public default List<Admin> findByName(String name) {
        return null;
    }


    // Check this Admin or not
    @Query("select user from Admin user" +
            " where  user.id =:id and user.type=1")
    public Optional<Integer> isAuth(@PathVariable long id);

    // check this exists or not
    @Query("select user from Admin user" +
            " where  user.id =:id")
    public Optional<Integer> userIsExists(@PathVariable long id);


}
