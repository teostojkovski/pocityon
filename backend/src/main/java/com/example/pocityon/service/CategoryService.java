package com.example.pocityon.service;

import com.example.pocityon.model.Category;
import com.example.pocityon.request.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(CreateCategoryRequest req);
    Category updateCategory(Long id, CreateCategoryRequest req);
    void deleteCategory(Long id);
}
