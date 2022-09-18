package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.dto.CommandeClientDto;
import com.khebli.gestiondestockproject.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {

    Optional<CommandeClient> findCommandeClientByCode(String code);
}
