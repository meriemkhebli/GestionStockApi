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
@Table(name = "fournisseur", schema = "public")
public class Fournisseur extends AbstractEntity {

    @Column(name ="nom")
    private String nom;

    @Column(name ="prenom")
    private String prenom;

    @Embedded
    private Adresse adresse;

    @Column(name ="photo")
    private String photo;

    @Column(name ="mail")
    private String mail;

    @Column(name ="num_tele")
    private String numTele;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;

    @Column(name="id_entreprise")
    private Integer idEntreprise;
}
