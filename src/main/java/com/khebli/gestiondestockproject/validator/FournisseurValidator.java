package com.khebli.gestiondestockproject.validator;

import com.khebli.gestiondestockproject.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate(FournisseurDto dto){
        List<String> errors = new ArrayList<>();
        if(dto ==null){
            errors.add("Veuillez rensigner le nom de fournisseur");
            errors.add("Veuillez rensigner le prenom de fournisseur");
            errors.add("Veuillez rensigner l'adresse de fournisseur");


        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez rensigner le nom de fournisseur");
        }
        if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez rensigner le prenom de fournisseur");
        }

        if(dto.getAdresse()==null){
            errors.add("Veuillez rensigner l'adresse de fournisseur");
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
        return errors;


    }
}
