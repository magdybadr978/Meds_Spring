package com.meds.repository;

import com.meds.errors.RecordNotFoundException;
import com.meds.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {


    // To Filter Medicines
    @Query("select med from Medicine med" +
            " where med.name like :nameBind%")
    public Optional<List<Medicine>> filterMedicine(@Param("nameBind") String name);





    public Optional<Medicine> findById(long id);

    public List<Medicine> findByName(String name);


}
