package com.meds.service;

import com.meds.model.Category;
import com.meds.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category>getAllCategory(){
        return categoryRepository.findAll();
    }
    public Optional<Category> getSpecificCategory(long id){
        return categoryRepository.findById(id);
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public void updateCategory(Category category){
        categoryRepository.save(category);
    }
    public void deleteCategory(long id){
        categoryRepository.deleteById(id);
    }
}
