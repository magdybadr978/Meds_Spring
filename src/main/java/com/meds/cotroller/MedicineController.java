package com.meds.cotroller;

import com.meds.model.Medicine;
import com.meds.service.MedicineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/all")
    public List<Medicine> getAllMedicines(){
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Medicine getMedicineById(@PathVariable long id){
        return medicineService.getMedicineById(id);
    }
    @GetMapping()
    public List<Medicine> filterMedicine(@RequestParam("nameBind") String name){
        return medicineService.filterMedicine(name);
    }

    @PostMapping("insert/{id}")
    public ResponseEntity<Medicine> insertMedicine(@RequestBody @Valid Medicine medicine, @PathVariable long id){
        medicineService.insertMedicine(medicine,id);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }
}
