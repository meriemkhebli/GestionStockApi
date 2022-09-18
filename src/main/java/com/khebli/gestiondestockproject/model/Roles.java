package com.khebli.gestiondestockproject.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "roles", schema = "public")
public class Roles extends AbstractEntity {


    @Column(name = "role_name")
    private String roleName;


    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;


}
