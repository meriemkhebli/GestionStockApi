package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CommandeFournisseurDto {
    private Integer Id;

    private String code;

    private Instant dateCmd;

    private FournisseurDto fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if(commandeFournisseur ==null){
            return null;
        }
        return CommandeFournisseurDto.builder()
                .Id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCmd(commandeFournisseur.getDateCmd())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .ligneCommandeFournisseurs
                        (
                                commandeFournisseur.getLigneCommandeFournisseurs()!=null ?
                                        commandeFournisseur.getLigneCommandeFournisseurs().stream()
                                                .map(LigneCommandeFournisseurDto::fromEntity)
                                                .collect(Collectors.toList()):null
                        )
                .build();
    }
    public static  CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto == null){
            return null;
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCmd(commandeFournisseurDto.getDateCmd());

        return commandeFournisseur;
    }
}
