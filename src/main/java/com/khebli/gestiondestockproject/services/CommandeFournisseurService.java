package com.khebli.gestiondestockproject.services;

import com.khebli.gestiondestockproject.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto dto);
    CommandeFournisseurDto findById(Integer id);

    CommandeFournisseurDto findCommandeFournisseurByCode(String codeC);

    List<CommandeFournisseurDto> findAll();

    void delete(Integer id);
}
