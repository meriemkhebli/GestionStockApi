package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.Article;
import com.khebli.gestiondestockproject.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {

    @Query("Select f from Fournisseur f where f.nom = :nom")
    Fournisseur findFournisseurByNom(@Param("nom") String  n);


}
