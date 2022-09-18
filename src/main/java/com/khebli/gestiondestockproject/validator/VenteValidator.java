package com.khebli.gestiondestockproject.validator;

import com.khebli.gestiondestockproject.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> Validate(VenteDto dto) {
        List<String> errors = new ArrayList<>();
        if(dto ==null){
            errors.add("Veuillez inserer le code");
            errors.add("Veuillez inserer la date");
            errors.add("Veuillez inserer les lignes ventes");

        }
        if(!StringUtils.hasLength(dto.getCode())){
            errors.add("Veuillez inserer le code");

        }
        if(dto.getDateVente()==null){
            errors.add("Veuillez inserer la date");
        }
        if(dto.getLigneVentes()==null){
            errors.add("Veuillez inserer les lignes ventes");
        }

        return errors;

    }
}
