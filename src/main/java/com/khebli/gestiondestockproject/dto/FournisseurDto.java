package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FournisseurDto {

    private Integer Id;
    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numTele;

    private List<CommandeFournisseurDto> commandeFournisseurs;

    public static FournisseurDto fromEntity( Fournisseur fournisseur){
        if (fournisseur ==null){
            return null;
        }

        return FournisseurDto.builder()
                .Id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .numTele(fournisseur.getNumTele())
                .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
                .commandeFournisseurs
                        (fournisseur.getCommandeFournisseurs()!=null ?
                                fournisseur.getCommandeFournisseurs().stream()
                                        .map(CommandeFournisseurDto::fromEntity)
                                        .collect(Collectors.toList()):null)
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto){
        if(fournisseurDto ==null){
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom((fournisseurDto.getNom()));
        fournisseur.setPrenom((fournisseurDto.getPrenom()));
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setNumTele(fournisseurDto.getNumTele());
        //client.getCommandeClients(LigneCommandeClientDto.LigneCommandeCli)

        return fournisseur;

    }

}
