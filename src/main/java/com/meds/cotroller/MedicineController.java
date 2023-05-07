package com.meds.cotroller;

import com.meds.model.Medicine;
import com.meds.repository.MedicineRepository;
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
    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/all")
    public List<Medicine> getAllMedicines(){
        return medicineService.getAllRecord();
    }

    @GetMapping("/{id}")
    public Medicine getMedicineById(@PathVariable long id){
        return medicineService.getRecordById( id);
    }

    @GetMapping()
    public List<Medicine> filterMedicine(@RequestParam("nameBind") String name){
        return medicineService.filterMedicine(name);
    }


    @PostMapping("insert")
    public ResponseEntity<Medicine> insertMedicine(
            @RequestBody @Valid Medicine medicine,
            @RequestHeader("adminID") long adminID) throws Exception {
        medicineService.insertRecord(medicine, medicine.getName(), adminID);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }
    @PutMapping("update/{medicineID}")
    public ResponseEntity<Medicine> updateMedicine(
            @RequestBody Medicine medicine,
            @PathVariable long medicineID,
            @RequestHeader("adminID") long adminID){
        medicine.setId(medicineID);// to update on the same medicine
        medicineService.updateRecord(medicine, medicineID, adminID);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    @DeleteMapping("delete/{medicineID}")
    public ResponseEntity<String> deleteMedicine(
            @PathVariable long medicineID,
            @RequestHeader("adminID") long adminID
    ){
        medicineService.deleteRecord(adminID, medicineID);
        return new ResponseEntity<>("medicine deleted successfully", HttpStatus.OK);

    }
}
