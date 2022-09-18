package com.khebli.gestiondestockproject.services.Impl;

import com.khebli.gestiondestockproject.dto.CommandeClientDto;
import com.khebli.gestiondestockproject.dto.LigneCommandeClientDto;
import com.khebli.gestiondestockproject.exception.EntityNotFoundException;
import com.khebli.gestiondestockproject.exception.ErrorCodes;
import com.khebli.gestiondestockproject.exception.InvalidEntityException;
import com.khebli.gestiondestockproject.model.Article;
import com.khebli.gestiondestockproject.model.Client;
import com.khebli.gestiondestockproject.model.CommandeClient;
import com.khebli.gestiondestockproject.model.LigneCommandeClient;
import com.khebli.gestiondestockproject.repository.ArticleRepository;
import com.khebli.gestiondestockproject.repository.ClientRepository;
import com.khebli.gestiondestockproject.repository.CommandeClientRepository;
import com.khebli.gestiondestockproject.repository.LigneCommandeClientRepository;
import com.khebli.gestiondestockproject.services.CommandeClientService;
import com.khebli.gestiondestockproject.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ArticleRepository articleRepository;
    private ClientRepository clientRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ArticleRepository articleRepository, ClientRepository clientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.articleRepository = articleRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("CMD Client n'est pas valide",dto);
            throw  new InvalidEntityException("La Commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALIDE,errors);
        }
        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if(client.isEmpty()){
         log.warn("Client avec Id "+dto.getClient().getId()+" n'existe pas dans la base");
         throw new EntityNotFoundException("Aucun Client avec l'id "+dto.getClient().getId()+"n'a été trouvé dans la BDD ", ErrorCodes.CLIENT_NOT_FOUND);
        }
        //verification des ligne commande client
        List<String> articleErrors = new ArrayList<>();
        if(dto.getLigneCommandeClients()!=null){
            dto.getLigneCommandeClients().forEach(ligneCmd->{
                if(ligneCmd.getArticle() !=null) {
                    Optional<Article> article = articleRepository.findById(ligneCmd.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("L'article avec l'ID"+ligneCmd.getArticle().getId()+"n'existe pas");
                    }
                }else{
                    articleErrors.add("L'article avec l'ID"+ligneCmd.getArticle().getId()+"n'existe pas");

                }
            });
        }


        if(!articleErrors.isEmpty()) {
            log.warn("Article n'existe pas dans la BDD");
            throw new InvalidEntityException("Article n'existe pas dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
        }

        CommandeClient savedCommandeClient =  commandeClientRepository.save(CommandeClientDto.toEntity(dto));
        dto.getLigneCommandeClients().forEach(lgCmdclt->{
            LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(lgCmdclt);
            ligneCommandeClient.setCommandeClient(savedCommandeClient);
            ligneCommandeClientRepository.save(ligneCommandeClient);

        });
        return CommandeClientDto.fromEntity(savedCommandeClient);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if(id==null){
            log.error("id n'existe pas");
            return null;
        }
        return commandeClientRepository.findById(id).map(CommandeClientDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucune Commande client avec l'ID"+id+"n'a été trouvé dans la BDD",ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDto findCommandeClientByCode(String codeC) {
        if(!StringUtils.hasLength(codeC)){
            log.error("code cmd client est null",codeC);
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(codeC).map(CommandeClientDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucune Commande client avec le code"+codeC+"n'a été trouvé dans la BDD",ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream().map(CommandeClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("id n'existe pas");
            return ;
        }
        commandeClientRepository.deleteById(id);

    }
}
