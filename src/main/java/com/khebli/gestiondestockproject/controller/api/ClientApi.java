package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.ClientDto;

import java.util.List;

public interface ClientApi {
    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    ClientDto findByNom(String nomClient);

    List<ClientDto> findAll();

    void delete(Integer id);
}
