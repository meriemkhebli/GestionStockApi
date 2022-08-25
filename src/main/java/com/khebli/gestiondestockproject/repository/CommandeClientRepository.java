package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {
}
