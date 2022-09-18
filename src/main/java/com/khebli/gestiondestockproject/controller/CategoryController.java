package com.khebli.gestiondestockproject.controller;

import com.khebli.gestiondestockproject.controller.api.CategoryApi;
import com.khebli.gestiondestockproject.dto.CategoryDto;
import com.khebli.gestiondestockproject.model.Category;
import com.khebli.gestiondestockproject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);

    }

    @Override
    public void delete(Category dto) {
        categoryService.delete(dto);
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {
        return categoryService.findByCodeCategory(codeCategory);
    }

    @Override
    public CategoryDto findByCodeByDesCategory(String code, String designation) {
        return categoryService.findByCodeByDesCategory(code, designation);
    }
}
