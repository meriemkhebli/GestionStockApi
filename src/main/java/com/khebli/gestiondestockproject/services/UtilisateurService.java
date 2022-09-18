package com.khebli.gestiondestockproject.services;

import com.khebli.gestiondestockproject.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto findByEmail(String login);

    List<UtilisateurDto> findAll();
    void delete(Integer id);

}
