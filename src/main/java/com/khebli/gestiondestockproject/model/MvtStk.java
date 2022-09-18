package com.khebli.gestiondestockproject.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "mvt_stk", schema = "public")
public class MvtStk extends AbstractEntity{

    @Column(name ="code_mvt")
    private String code;

    @Column(name="date_mvt")
    private Instant dateMvt;
    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @Column(name = "type_mvt")
    private TypeStkMvt typeMvt;

    @Column(name="qte_mvt")
    private BigDecimal qteMvt;

    @Column(name="id_entreprise")
    private Integer idEntreprise;

}
