package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.Vente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VenteDto {

    private Integer Id;

    private String code;

    private Instant dateVente;

    private List<LigneVenteDto> ligneVentes;

    private String commentaire;


    public static VenteDto fromEntity(Vente vente){
        if(vente ==null){
            return null;
        }
        return VenteDto.builder()
                .Id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .ligneVentes(
                        vente.getLigneVentes()!=null ?
                                vente.getLigneVentes().stream()
                                        .map(LigneVenteDto::fromEntity)
                                        .collect(Collectors.toList()):null

                ).build();

    }
    public static Vente toEntity(VenteDto venteDto){

        if(venteDto == null){
            return null;
        }

        Vente vente = new Vente();
        vente.setId(venteDto.getId());
        vente.setCode(venteDto.getCode());
        vente.setDateVente(venteDto.getDateVente());
        vente.setCommentaire(venteDto.getCommentaire());
        return vente;
    }
}
