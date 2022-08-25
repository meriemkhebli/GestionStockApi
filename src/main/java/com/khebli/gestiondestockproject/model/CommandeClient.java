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
@Table(name = "commande_client", schema = "public")
public class CommandeClient extends AbstractEntity{

    @Column(name ="code_cmd")
    private String code;

    @Column(name="date_cmd")
    private Instant dateCmd;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;

}
