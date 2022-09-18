package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    @Query("select u from Utilisateur u where u.login = :login")
    Utilisateur findUtilisateursByLogin(@Param("login")String login);

    Optional<Utilisateur> findByEmail(String email);


}
