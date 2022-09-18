package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.CommandeClient;
import com.khebli.gestiondestockproject.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

}
