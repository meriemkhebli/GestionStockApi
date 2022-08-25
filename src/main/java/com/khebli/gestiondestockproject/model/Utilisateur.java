package com.khebli.gestiondestockproject.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name="utilisateur", schema = "public")
public class Utilisateur extends AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;


    @Column(name = "email")
    private String email;

    @Column(name = "date_naissance")
    private Instant dateNaissance;


    @Column(name = "photos")
    private String photos;

    @Embedded
    private Adresse adresse;


    @Column(name = "login")
    private String login;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name ="id_entreprise")
    private Entreprise entreprise;

    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> roles;


}
