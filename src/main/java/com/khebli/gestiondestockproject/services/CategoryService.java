package com.khebli.gestiondestockproject.services;

import com.khebli.gestiondestockproject.dto.CategoryDto;
import com.khebli.gestiondestockproject.model.Category;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Integer id);

    List<CategoryDto> findAll();

    void delete(Integer id);

    void delete(Category dto);

    CategoryDto findByCodeCategory( String codeCategory);

    CategoryDto findByCodeByDesCategory(String code, String designation);

}
