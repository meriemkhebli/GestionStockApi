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
@Table(name = "ligne_commande_client", schema = "public")
public class LigneCommandeClient extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @ManyToOne
    @JoinColumn(name="id_cmd_client")
    private CommandeClient commandeClient;

    @Column(name="qte_cmd")
    private BigDecimal qteCmd;

    @Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;
}
