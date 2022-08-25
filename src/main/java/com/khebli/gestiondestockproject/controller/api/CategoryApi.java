package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.CategoryDto;
import com.khebli.gestiondestockproject.model.Category;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.khebli.gestiondestockproject.utils.Constants.APP_ROOT;

public interface CategoryApi {

    @PostMapping(value = APP_ROOT+"/categorie/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    CategoryDto save(CategoryDto dto);

    @GetMapping(value = APP_ROOT+"/categorie/{IdCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("IdCategorie") Integer id);

    @GetMapping(value = APP_ROOT +"/categorie/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT +"/categorie/delete/{IdCategorie}")
    void delete(@PathVariable("IdCategorie") Integer id);

    @DeleteMapping(value = APP_ROOT +"categorie/delete/")
    void delete(Category dto);

    @GetMapping(value = APP_ROOT+"/categorie/{codeCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(@PathVariable("codeCategorie") String codeCategory);

    @GetMapping(value = APP_ROOT+"/categorie/{codeCategorie}/{designationCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeByDesCategory(@PathVariable("codeCategorie")String code, @PathVariable("designationCategorie")String designation);
}
