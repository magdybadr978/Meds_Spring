package com.meds.cotroller;

import com.meds.model.Medicine;
import com.meds.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Medicine getMedicineById(@PathVariable long id){
        return medicineService.getMedicineById(id);
    }
    @GetMapping()
    private List<Medicine> filterMedicine(@RequestParam("nameBind") String name){
        return medicineService.filterMedicine(name);
    }





}
