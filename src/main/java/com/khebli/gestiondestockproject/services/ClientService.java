package com.khebli.gestiondestockproject.services;

import com.khebli.gestiondestockproject.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    ClientDto findByNom(String nomClient);

    List<ClientDto> findAll();

    void delete(Integer id);
}
