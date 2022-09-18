package com.khebli.gestiondestockproject.validator;

import org.springframework.util.StringUtils;
import com.khebli.gestiondestockproject.dto.ArticleDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto dto){
        List<String> errors = new ArrayList<>();
        if(dto ==null){
//            errors.add("Veuillez rensigner le code de l'article");
//            errors.add("Veuillez rensigner la desigantion de l'article");
//            errors.add("Veuillez rensigner le prix unitaire de l'article");
//            errors.add("Veuillez rensigner le prix unitaire  TTC de l'article");
//            errors.add("Veuillez rensigner le taux TVA de l'article");
//            errors.add("Veuillez sélectionner une catégorie");
        }
//        if (!StringUtils.hasLength(dto.getCodeArticle())) {
//            errors.add("Veuillez rensigner le code de l'article");
//        }
//        if (!StringUtils.hasLength(dto.getDesignation())) {
//            errors.add("Veuillez rensigner la desigantion de l'article");
//        }
//        if (dto.getPrixunitaire() == null || dto.getPrixunitaire().compareTo(BigDecimal.ZERO) == 1) {
//            errors.add("Veuillez rensigner le prix unitaire de l'article");
//        }
//        if (dto.getPrixunitaireTTC() == null || dto.getPrixunitaire().compareTo(BigDecimal.ZERO) == 1) {
//            errors.add("Veuillez rensigner le prix unitaire  TTC de l'article");
//        }
//        if (dto.getTauxTVA() == null) {
//            errors.add("Veuillez rensigner le taux TVA de l'article");
//        }
//        if (dto.getCategory() == null) {
//            errors.add("Veuillez selectionner une categorie");
//        }
      return errors;
  }
}
