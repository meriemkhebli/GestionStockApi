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
@Table(name = "ligne_vente", schema = "public")
public class LigneVente extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "id_vente")
    private Vente vente;

    @Column(name="qte")
    private BigDecimal qte;

    @Column(name="prix")
    private BigDecimal prix;
}
