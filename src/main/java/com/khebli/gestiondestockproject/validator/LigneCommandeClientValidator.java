package com.khebli.gestiondestockproject.validator;

import com.khebli.gestiondestockproject.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto dto){
        List<String> errors = new ArrayList<>();
        if(dto ==null) {
            errors.add("Veuillez rensigner le code commande");
            errors.add("Veuillez rensigner la date  commande");
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez selectionner le client");
        }
        return errors;
    }
}
