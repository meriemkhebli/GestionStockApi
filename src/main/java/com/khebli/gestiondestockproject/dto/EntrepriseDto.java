package com.khebli.gestiondestockproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khebli.gestiondestockproject.model.Entreprise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntrepriseDto {

    private Integer Id;
    private String nom;

    private String description;

    private String codeFiscal;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numTele;

    private String siteWeb;

    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;

//    @JsonIgnore
//    private List<ArticleDto>articles;

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise ==null){
            return null;

        }
       return EntrepriseDto.builder()
                .Id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
               .mail(entreprise.getMail())
               .siteWeb(entreprise.getSiteWeb())
               .utilisateurs
                       (
                       entreprise.getUtilisateurs()!=null ?
                       entreprise.getUtilisateurs().stream()
                               .map(UtilisateurDto::fromEntity)
                               .collect(Collectors.toList()):null

                       )
//               .articles
//                       (
//                               entreprise.getArticles()!=null ?
//                                       entreprise.getArticles().stream()
//                                               .map(ArticleDto::fromEntity)
//                                               .collect(Collectors.toList()):null
//
//                       )
                .build();

    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto==null){
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setNumTele(entrepriseDto.getNumTele());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        entreprise.setMail(entrepriseDto.getMail());
       // entreprise.setUtilisateurs(entrepriseDto.getUtilisateurs());
      //  entreprise.setAdresse(entrepriseDto.getAdresse());
        return entreprise;



    }


}
