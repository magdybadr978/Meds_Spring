package com.meds.cotroller;

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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getAllCategory")
    public List<Category>getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/getSpecificCategory/{id}")
    public Optional<Category> getSpecificCategory(@PathVariable long id){
        return categoryService.getSpecificCategory(id);
    }
    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody @Valid Category category){
        categoryService.addCategory(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @PutMapping("/updateCategory")
    public ResponseEntity<String> updateCategory(@RequestBody @Valid Category category){
        categoryService.updateCategory(category);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
