package com.meds.cotroller;

import com.meds.configration.AdminAuthorization;
import com.meds.model.Category;
import com.meds.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AdminAuthorization adminAuthorization;


    @GetMapping("/getAllCategory")
    public List<Category>getAllCategory(){
        return categoryService.getAllRecord();
    }

    @GetMapping("/{id}")
    public Category getSpecificCategory(@PathVariable long id){
        return categoryService.getRecordById(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<Category> addCategory(
            @RequestBody @Valid Category category,
            @RequestHeader("adminID") long adminID){
        adminAuthorization.isAdmin(adminID);
        categoryService.insertRecord(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<String> updateCategory(
            @RequestBody @Valid Category category,
            @RequestHeader("adminID") long adminID,
            @PathVariable long categoryId){
        adminAuthorization.isAdmin(adminID);
        categoryService.updateRecord(category, categoryId);
        return new ResponseEntity<>("Category updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<String> deleteCategory(
            @PathVariable long categoryId,
            @RequestHeader("adminID") long adminID){
        adminAuthorization.isAdmin(adminID);
        categoryService.deleteRecord(categoryId);
        return new ResponseEntity<>("CategoryDeleted Successfully", HttpStatus.OK);
    }
}
