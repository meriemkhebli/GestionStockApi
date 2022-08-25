package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {
    private Integer Id;

    private String nom;

    private String prenom;


    private String email;

    private Instant dateNaissance;


    private String photos;

    private AdresseDto adresse;


    private String login;

    private String motDePasse;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if(utilisateur==null){
            return null;
        }
      return  UtilisateurDto.builder()
                .Id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getNom())
                .dateNaissance(utilisateur.getDateNaissance())
                .photos(utilisateur.getPhotos())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .login(utilisateur.getLogin())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
              .roles(
                      utilisateur.getRoles()!=null ?
                              utilisateur.getRoles().stream()
                                      .map(RolesDto::fromEntity)
                                      .collect(Collectors.toList()):null

              )
                .build();

    }
    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){

        if(utilisateurDto ==null){
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom((utilisateurDto.getPrenom()));
        utilisateur.setDateNaissance((utilisateurDto.getDateNaissance()));
        utilisateur.setPhotos((utilisateurDto.getPhotos()));
        utilisateur.setLogin((utilisateurDto.getLogin()));


        return utilisateur;

    }
}
