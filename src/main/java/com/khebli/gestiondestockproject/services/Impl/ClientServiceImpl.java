package com.khebli.gestiondestockproject.services.Impl;

import com.khebli.gestiondestockproject.dto.ArticleDto;
import com.khebli.gestiondestockproject.dto.ClientDto;
import com.khebli.gestiondestockproject.exception.EntityNotFoundException;
import com.khebli.gestiondestockproject.exception.ErrorCodes;
import com.khebli.gestiondestockproject.model.Client;
import com.khebli.gestiondestockproject.repository.ClientRepository;
import com.khebli.gestiondestockproject.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        Client clientSaved = clientRepository.save(ClientDto.toEntity(dto));
        return ClientDto.fromEntity(clientSaved);
    }

    @Override
    public ClientDto findById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(()->new EntityNotFoundException("Aucun client avec l'Id"+id+"n'a été trouvé dans la BDD", ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public ClientDto findByNom(String nomClient) {
        Client client = clientRepository.findClientByNom(nomClient);
        return ClientDto.fromEntity(client);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);

    }
}
