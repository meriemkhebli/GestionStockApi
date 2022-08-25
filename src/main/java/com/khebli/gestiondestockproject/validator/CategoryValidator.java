package com.khebli.gestiondestockproject.validator;

import com.khebli.gestiondestockproject.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(CategoryDto dto){
        List<String> errors = new ArrayList<>();
        if(dto==null){
            errors.add("Veuillez rensigner le code de la catégorie");
            errors.add("Veuillez rensigner la desigantion de la catégorie");
        }
        if(!StringUtils.hasLength(dto.getCode())){
            errors.add("Veuillez rensigner le code de la catégorie");
        }
        if(!StringUtils.hasLength(dto.getDesignation())){
            errors.add("Veuillez rensigner la desigantion de la catégorie");
        }

        return errors;
    }
}
