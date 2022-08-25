package com.khebli.gestiondestockproject.validator;

import com.khebli.gestiondestockproject.dto.ClientDto;
import com.khebli.gestiondestockproject.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto dto){
        List<String> errors = new ArrayList<>();
        if(dto ==null){
            errors.add("Veuillez rensigner le nom de l'utilisateur");
            errors.add("Veuillez rensigner le prenom de l'utilisateur");
            errors.add("Veuillez rensigner la date naissance de l'utilisateur");
            errors.add("Veuillez rensigner le login de l'utilisateur");
            errors.add("Veuillez rensigner le mot de passe de l'utilisateur");
            errors.add("Veuillez rensigner l'adresse de l'utilisateur");
            errors.add("Veuillez selectionner au moin un role utilisateur");

        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez rensigner le nom de l'utilisateur");
        }
        if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez rensigner le prenom de l'utilisateur");
        }
        if(dto.getDateNaissance()==null){
            errors.add("Veuillez rensigner la date naissance de l'utilisateur");
        }

        if(!StringUtils.hasLength(dto.getLogin())){
            errors.add("Veuillez rensigner le login de l'utilisateur");
        }
        if(!StringUtils.hasLength(dto.getMotDePasse())){
            errors.add("Veuillez rensigner le mot de passe de l'utilisateur");
        }
        if(dto.getAdresse()==null){
            errors.add("Veuillez rensigner l'adresse de l'utilisateur");
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
            if(dto.getRoles().isEmpty()){
                errors.add("Veuillez selectionner au moin un role utilisateur");


            }
        }
        return errors;


    }
}
