package com.khebli.gestiondestockproject.services;

import com.khebli.gestiondestockproject.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto save(EntrepriseDto dto);
    EntrepriseDto findById(Integer id);
    List<EntrepriseDto> findAll();

    EntrepriseDto findByNom(String nom);
    void delete(Integer id);
}
