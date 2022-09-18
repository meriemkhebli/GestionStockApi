package com.khebli.gestiondestockproject.validator;

import com.khebli.gestiondestockproject.dto.CommandeClientDto;
import com.khebli.gestiondestockproject.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public static List<String> validate(CommandeFournisseurDto dto){
        List<String> errors = new ArrayList<>();
        if(dto ==null) {
            errors.add("Veuillez rensigner le code commande");
            errors.add("Veuillez rensigner la date  commande");
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez selectionner le client");
        }
        if(!StringUtils.hasLength(dto.getCode())){
            errors.add("Veuillez rensigner le code commande");
        }
        if((dto.getDateCmd()==null)){
            errors.add("Veuillez rensigner la date  commande");
        }
        if(dto.getFournisseur()==null){
            errors.add("Veuillez selectionner l'article");
        }
        if(dto.getLigneCommandeFournisseurs().isEmpty()){
            errors.add("Veuillez ajouter les ligne commande");


        }
        return errors;
    }
}
