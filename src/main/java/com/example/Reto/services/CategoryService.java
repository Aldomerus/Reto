package com.example.Reto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto.entities.Category;
import com.example.Reto.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Metodos CRUD

    public List<Category> getlistCategory() {
        return this.categoryRepository.findAll();
    }

    public Category getCategory(int id) {
        if (!this.categoryRepository.findById(id).isEmpty()) {

            return this.categoryRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Category createCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public void deleteCategory(int id) {
        if (!this.categoryRepository.findById(id).isEmpty()) {

            this.categoryRepository.deleteById(id);
        }
    }

    public void updateCategory(int id, Category category) {

        Category categoryDB = this.categoryRepository.findById(id).get();

        if (!this.categoryRepository.findById(id).isEmpty()) {
            if(category.getName() != null){
                categoryDB.setName((category.getName()));
            }
            if(category.getDescription() != null){
                categoryDB.setDescription((category.getDescription()));
            }
 

            this.categoryRepository.save(categoryDB);
        }
    }

}
