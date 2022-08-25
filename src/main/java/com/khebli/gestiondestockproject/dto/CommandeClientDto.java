package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CommandeClientDto {
    private Integer Id;

    private String code;

    private Instant dateCmd;

    private ClientDto client;

    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient ==null){
            return null;
        }
        return CommandeClientDto.builder()
                .Id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCmd(commandeClient.getDateCmd())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .ligneCommandeClients
                        (
                                commandeClient.getLigneCommandeClients()!=null ?
                                        commandeClient.getLigneCommandeClients().stream()
                                                .map(LigneCommandeClientDto::fromEntity)
                                                .collect(Collectors.toList()):null
                        )
                .build();
    }
    public static  CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto == null){
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCmd(commandeClientDto.getDateCmd());

        return commandeClient;
    }
}
