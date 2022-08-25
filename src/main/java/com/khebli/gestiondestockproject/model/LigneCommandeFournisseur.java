package com.khebli.gestiondestockproject.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "ligne_commande_fournisseur", schema = "public")
public class LigneCommandeFournisseur extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @ManyToOne
    @JoinColumn(name="id_cmd_fournisseur")
    private CommandeFournisseur commandeFournisseur;

    @Column(name="qte_cmd")
    private BigDecimal qteCmd;

    @Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;
}
