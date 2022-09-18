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
@Table(name = "commande_fournisseur", schema = "public")
public class CommandeFournisseur extends AbstractEntity{

    @Column(name ="code_cmd")
    private String code;

    @Column(name="date_cmd")
    private Instant dateCmd;

    @ManyToOne
    @JoinColumn(name="id_fournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @Column(name="id_entreprise")
    private Integer idEntreprise;
}
