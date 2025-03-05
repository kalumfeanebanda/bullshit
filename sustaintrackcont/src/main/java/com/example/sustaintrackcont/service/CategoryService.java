package com.example.sustaintrackcont.service;

import com.example.sustaintrackcont.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category addCategory(Category category);
    Category getCategoryById(Long id);
    boolean deleteCategoryById(Long id); // Ad


}
