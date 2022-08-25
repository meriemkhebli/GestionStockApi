package com.khebli.gestiondestockproject.validator;

import com.khebli.gestiondestockproject.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto dto){
        List<String> errors = new ArrayList<>();
        if(dto ==null){
            errors.add("Veuillez rensigner le nom de l'entreprise");
            errors.add("Veuillez rensigner la description de l'entreprise");
            errors.add("Veuillez rensigner l'adresse de l'entreprise");
            errors.add("Veuillez rensigner le numero de téléphone de l'entreprise");


        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez rensigner le nom de l'entreprise");
        }
        if(!StringUtils.hasLength(dto.getDescription())){
            errors.add("Veuillez rensigner la description de l'entreprise");
        }


        if(dto.getAdresse()==null){
            errors.add("Veuillez rensigner l'adresse de l'entreprise");
        }else {
            if (!StringUtils.hasLength(dto.getAdresse().getAdresse1())) {
                errors.add("Le champs  adresse1 est obligatoire");

            }
            if (!StringUtils.hasLength(dto.getAdresse().getPays())) {
                errors.add("Le champs  pays est obligatoire");
            }
            if (!StringUtils.hasLength(dto.getAdresse().getCodePostal())) {
                errors.add("Le champs code postal est obligatoire");
            }
        }
        if(!StringUtils.hasLength(dto.getNumTele())){
            errors.add("Veuillez rensigner le numero de téléphone de l'entreprise");
        }
        return errors;


    }
}
