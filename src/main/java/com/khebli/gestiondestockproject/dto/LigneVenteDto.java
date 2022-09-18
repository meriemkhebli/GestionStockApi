package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.LigneVente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LigneVenteDto {
    private Integer Id;

    private ArticleDto article;

    private VenteDto vente;

    private BigDecimal qte;

    private BigDecimal prix;

    public static LigneVenteDto fromEntity(LigneVente ligneVente){
         if(ligneVente ==null){
             return null;
         }
         return LigneVenteDto.builder()
                 .Id(ligneVente.getId())
                 .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                 .vente(VenteDto.fromEntity(ligneVente.getVente()))
                 .qte(ligneVente.getQte())
                 .prix(ligneVente.getPrix())
                 .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto ==null){
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setQte(ligneVenteDto.getQte());
        ligneVente.setPrix(ligneVenteDto.getPrix());

        return ligneVente;
    }
}
