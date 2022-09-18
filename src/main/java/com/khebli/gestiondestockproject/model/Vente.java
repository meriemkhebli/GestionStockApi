package com.khebli.gestiondestockproject.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "vente", schema = "public")
public class Vente extends AbstractEntity{

    @Column(name ="code_vente")
    private String code;

    @Column(name="date_vente")
    private Instant dateVente;

    @OneToMany(mappedBy = "vente")
   private List<LigneVente> ligneVentes;

    @Column(name ="commentaire")
    private String commentaire;

    @Column(name="id_entreprise")
    private Integer idEntreprise;

}
