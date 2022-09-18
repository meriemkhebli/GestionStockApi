package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.dto.EntrepriseDto;
import com.khebli.gestiondestockproject.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {

    @Query("select e from Entreprise e  where e.nom = :nom")
    Entreprise findEntrepriseByNom(@Param("nom")String n);
}
