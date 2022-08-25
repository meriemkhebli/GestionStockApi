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
@Table(name = "client", schema = "public")
public class Client extends AbstractEntity {


    @Column(name ="nom")
    private String nom;

    @Column(name ="prenom")
    private String prenom;

    @Embedded
    private Adresse adresse;

    @Column(name ="url_photo")
    private String photo;

    @Column(name ="mail")
    private String mail;

    @Column(name ="num_tele")
    private String numTele;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;

}
