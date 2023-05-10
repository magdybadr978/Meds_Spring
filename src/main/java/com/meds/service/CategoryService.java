package com.meds.service;

import com.meds.errors.RecordNotFoundException;
import com.meds.model.Category;
import com.meds.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService extends MainService<Category, Long>{
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }

    @Override
    public <T> void checksBeforeInsert(T check) {
        Category category = (Category) check;
        alreadyExists(category.getName());
    }

    @Override
    public <T> void checksBeforeUpdate(T check) {
        Category category = (Category) check;
        notFound(category.getId());
    }

    @Override
    public <T> void checksBeforeDelete(T check) {
        notFound((long) check);
    }

    @Override
    public <T> Category prepareRecordForUpdate(Category categoryFromBody) {
        return categoryFromBody;
    }

    public void notFound(long id) {
        if(!categoryRepository.existsCategoriesById(id)){
            throw new RecordNotFoundException("this Category not found");
        };
    }


    public void alreadyExists(String name) {
        if(categoryRepository.existsCategoriesByName(name)){
            throw new RuntimeException("this category already exists");
        };
    }
}
