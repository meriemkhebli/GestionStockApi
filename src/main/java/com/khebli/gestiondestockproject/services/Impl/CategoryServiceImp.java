package com.khebli.gestiondestockproject.services.Impl;

import com.khebli.gestiondestockproject.dto.ArticleDto;
import com.khebli.gestiondestockproject.dto.CategoryDto;
import com.khebli.gestiondestockproject.exception.EntityNotFoundException;
import com.khebli.gestiondestockproject.exception.ErrorCodes;
import com.khebli.gestiondestockproject.exception.InvalidEntityException;
import com.khebli.gestiondestockproject.model.Article;
import com.khebli.gestiondestockproject.model.Category;
import com.khebli.gestiondestockproject.repository.CategoryRepository;
import com.khebli.gestiondestockproject.services.CategoryService;
import com.khebli.gestiondestockproject.validator.ArticleValidator;
import com.khebli.gestiondestockproject.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImp implements CategoryService {

    CategoryRepository categoryRepository;
//injection par constructeur
    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Categorie est non valide{}",dto);
            throw new InvalidEntityException("Categorie n'est pas valide", ErrorCodes.CATEGORIE_NOT_VALIDE,errors);
        }
           Category categorySaved = categoryRepository.save(CategoryDto.toEntity(dto));
          return CategoryDto.fromEntity(categorySaved);
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id==null){
            log.error("id not found");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);

        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException("Aucun category avec l'Id"+id+"n'a été trouvé dans la BDD",ErrorCodes.CATEGORIE_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null) {
            log.error("l'id est null");
             return;
        }

        categoryRepository.deleteById(id);

    }

    @Override
    public void delete(Category dto) {

        categoryRepository.delete(dto);
    }


    public CategoryDto findByCodeByDesCategory(String code, String designation) {
        Category categorie=  categoryRepository.findCategoryByCodeByDesignation(code, designation);
        return CategoryDto.fromEntity(categorie);
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {
        if(!StringUtils.hasLength(codeCategory)){
             log.error("category code  is null");
            return null;
        }
     //   return categoryRepository.findCategoryByCode(codeCategory).map(CategoryDto::fromEntity).orElseThrow(()->new EntityNotFoundException("Aucun article avec le code"+codeCategory+"n'a été trouvé dans la BDD",ErrorCodes.CATEGORIE_NOT_FOUND));
       Category category= categoryRepository.findCategoryByCode(codeCategory);
       return Optional.of(CategoryDto.fromEntity(category)).orElseThrow(()->new EntityNotFoundException("Aucun article avec le code"+codeCategory+"n'a été trouvé dans la BDD",ErrorCodes.CATEGORIE_NOT_FOUND));
    }

}
