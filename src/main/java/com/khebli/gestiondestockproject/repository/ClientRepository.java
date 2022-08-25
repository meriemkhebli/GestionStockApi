package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.Article;
import com.khebli.gestiondestockproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Query("Select c from Client c where c.nom= :nom")
    Client findClientByNom(@Param("nom")String n);

}
