package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
}
