package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer Id;
    private ArticleDto article;

    private CommandeFournisseurDto commandeFournisseur;

    private BigDecimal qteCmd;

    private BigDecimal prixUnitaire;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){

        if(ligneCommandeFournisseur==null){
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .Id(ligneCommandeFournisseur.getId())
                .article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .commandeFournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
                .qteCmd(ligneCommandeFournisseur.getQteCmd())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFourniseeurDto){
        if (ligneCommandeFourniseeurDto ==null){
            return null;
        }
        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFourniseeurDto.getId());
        ligneCommandeFournisseur.setQteCmd(ligneCommandeFourniseeurDto.getQteCmd());
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFourniseeurDto.getPrixUnitaire());

        return ligneCommandeFournisseur;
    }

}
