package com.khebli.gestiondestockproject.services;

import com.khebli.gestiondestockproject.dto.ArticleDto;
import com.khebli.gestiondestockproject.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {
    // ce service set similaire cmdfournisseur et vente
    CommandeClientDto save( CommandeClientDto dto);
    CommandeClientDto findById(Integer id);

    CommandeClientDto findCommandeClientByCode(String codeC);

    List<CommandeClientDto> findAll();

    void delete(Integer id);


}
