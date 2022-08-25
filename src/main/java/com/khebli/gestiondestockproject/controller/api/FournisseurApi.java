package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.FournisseurDto;

import java.util.List;

public interface FournisseurApi {

    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Integer id);

    FournisseurDto findFournisseurByNom(String nomFournisseur);

    List<FournisseurDto> findAll();

    void delete (Integer id);

}
