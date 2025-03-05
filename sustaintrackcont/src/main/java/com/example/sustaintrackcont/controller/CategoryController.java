package com.example.sustaintrackcont.controller;


import com.example.sustaintrackcont.model.Category;
import com.example.sustaintrackcont.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5174") // Allow Vue frontend
@RestController
@RequestMapping("/category") // Base URL for all endpoints
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 1. Get All Employees
    @GetMapping
    public ResponseEntity<List<Category>> getAllEmployee() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    // 2. Get an Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return (category != null) ? ResponseEntity.ok(category) :
                ResponseEntity.notFound().build();
    }

    // 3. Create a New Employee
    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category
                                                           category) {
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    // 4. Update an Existing Employee
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @Valid
    @RequestBody Category updatedCategory) {
        Category existingCategory = categoryService.getCategoryById(id);
        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }
        updatedCategory.setId(id); // Ensure the correct ID is used
        Category savedCategory = categoryService.addCategory(updatedCategory);
        return ResponseEntity.ok(savedCategory);
    }

    // 5. Delete an Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        boolean isDeleted = categoryService.deleteCategoryById(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        }
        return ResponseEntity.ok("Category deleted successfully!");
    }



}
