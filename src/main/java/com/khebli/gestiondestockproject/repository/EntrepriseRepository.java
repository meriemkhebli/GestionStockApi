package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
}
