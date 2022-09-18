package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.Article;
import com.khebli.gestiondestockproject.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VenteRepository extends JpaRepository<Vente,Integer> {
    Optional<Vente> findVenteByCode(String code);

}
