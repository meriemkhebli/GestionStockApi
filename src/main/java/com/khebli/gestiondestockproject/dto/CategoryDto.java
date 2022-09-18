package com.khebli.gestiondestockproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khebli.gestiondestockproject.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Integer Id;
    private String code;

    private String designation;

    @JsonIgnore
    private List<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category){
        if( category == null){
            return null;
            //to throw exception

        }
        return CategoryDto.builder()
                .Id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();

    }

    public static Category toEntity(CategoryDto categoryDto){
        if( categoryDto == null){
            return null;
                }
        Category category= new Category();
             category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        return  category;

    }
}
