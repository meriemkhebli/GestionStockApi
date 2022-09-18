package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {


    private Integer Id;

    private String codeArticle;

    private String Designation;

    private BigDecimal prixunitaire;

    private BigDecimal tauxTVA;

    private BigDecimal prixunitaireTTC;

    private String photo;

    private CategoryDto category;

    private EntrepriseDto entreprise;

    public static ArticleDto fromEntity(Article article){
        if(article ==null){
             return null;
        }
         return ArticleDto.builder()
                 .Id(article.getId())
                 .codeArticle(article.getCodeArticle())
                 .Designation(article.getDesignation())
                 .prixunitaire(article.getPrixunitaire())
                 .prixunitaireTTC(article.getPrixunitaireTTC())
                 .tauxTVA(article.getTauxTVA())
                 .photo(article.getPhoto())
                 .category(CategoryDto.fromEntity(article.getCategory()))
                // .entreprise(EntrepriseDto.fromEntity(article.getEntreprise()))
                 .build();

    }
    public static Article toEntity(ArticleDto articleDto){

        if (articleDto==null){
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixunitaire(articleDto.getPrixunitaire());
        article.setPrixunitaireTTC(articleDto.getPrixunitaireTTC());
        article.setTauxTVA(articleDto.getTauxTVA());
        article.setPhoto(articleDto.getPhoto());

        return  article;
    }

}
