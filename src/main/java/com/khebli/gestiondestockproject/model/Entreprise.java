package com.khebli.gestiondestockproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "entreprise", schema = "public")
public class Entreprise extends AbstractEntity{

    @Column(name ="nom")
    private String nom;

    @Column(name ="description")
    private String description;

    @Embedded
    private Adresse adresse;

    @Column(name ="photo")
    private String photo;

    @Column(name ="mail")
    private String mail;

    @Column(name ="num_tele")
    private String numTele;

    @Column(name ="site_web")
    private String siteWeb;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;

    @OneToMany(mappedBy = "entreprise")
    private List<Article>articles;
}
