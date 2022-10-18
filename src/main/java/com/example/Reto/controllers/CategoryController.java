package com.example.Reto.controllers;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.entities.Category;
import com.example.Reto.services.CategoryService;

@Service
@RestController
@RequestMapping ("/api/Category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @GetMapping ("/all")
    public ResponseEntity<List<Category>> getCategorys(){
        return new ResponseEntity<List<Category>>(this.categoryService.getlistCategory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") int id){
        return new ResponseEntity<Category>(this.categoryService.getCategory(id), HttpStatus.OK);
    }
    @PostMapping ("/save")
    public ResponseEntity<Void> createCategory(@RequestBody Category category){
        this.categoryService.createCategory(category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<String>("Category deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@RequestBody Category category){
        this.categoryService.updateCategory(category.getId(), category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }    
    
} 
