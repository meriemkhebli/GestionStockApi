package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.Adresse;
import com.khebli.gestiondestockproject.model.Client;
import com.khebli.gestiondestockproject.model.CommandeClient;
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
public class ClientDto {

    private Integer Id;
    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numTele;

    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity( Client client){
        if (client ==null){
            return null;
        }

        return ClientDto.builder()
                .Id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTele(client.getNumTele())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .commandeClients
                        (client.getCommandeClients()!=null ?
                                client.getCommandeClients().stream()
                                        .map(CommandeClientDto::fromEntity)
                                        .collect(Collectors.toList()):null)

                .build();
    }
    public static Client toEntity(ClientDto clientDto){
        if(clientDto ==null){
            return null;
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom((clientDto.getNom()));
        client.setPrenom((clientDto.getPrenom()));
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumTele(clientDto.getNumTele());
        //client.getCommandeClients((CommandeClient)clientDto.getCommandeClients());

        return client;

    }
}
