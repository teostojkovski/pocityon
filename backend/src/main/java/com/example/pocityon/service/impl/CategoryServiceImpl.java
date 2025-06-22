package com.example.pocityon.service.impl;

import com.example.pocityon.model.Category;
import com.example.pocityon.repository.CategoryRepository;
import com.example.pocityon.request.CreateCategoryRequest;
import com.example.pocityon.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public Category createCategory(CreateCategoryRequest req) {
        Category category = new Category();
        category.setName(req.getName());
        category.setIcon(req.getIcon());
        category.setSuggestions(req.getSuggestions());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, CreateCategoryRequest req) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(req.getName());
        category.setIcon(req.getIcon());
        category.setSuggestions(req.getSuggestions());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
