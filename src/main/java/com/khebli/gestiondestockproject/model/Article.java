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
@Table(name = "article" , schema = "public")
public class Article extends AbstractEntity{

    @Column(name ="code_article")
    private String codeArticle;

    @Column(name="designation_article")
    private String designation;

    @Column(name="prix_unitaire_article")
    private BigDecimal prixunitaire;

    @Column(name="tauxtvaarticle")
    private BigDecimal tauxTVA;

    @Column(name="prix_unitaire_ttc_article")
    private BigDecimal prixunitaireTTC;

    @Column(name="photo")
    private String photo;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    //@ManyToOne
  //  @JoinColumn(name = "id_entreprise")

    @Column(name="id_entreprise")
    private Integer idEntreprise;


}
