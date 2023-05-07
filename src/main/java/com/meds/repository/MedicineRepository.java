package com.meds.repository;

import com.meds.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

//    JpaRepository<Medicine, Long>
    // To Filter Medicines
    @Query("select med from Medicine med" +
            " where med.name like :nameBind%")
    public Optional<List<Medicine>> filterMedicine(@Param("nameBind") String name);

    public boolean existsMedicineByName(String name);

    public boolean existsMedicineById(long id);






}
