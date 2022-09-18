package com.khebli.gestiondestockproject.services.Impl;

import com.khebli.gestiondestockproject.dto.CommandeClientDto;
import com.khebli.gestiondestockproject.dto.CommandeFournisseurDto;
import com.khebli.gestiondestockproject.dto.LigneCommandeFournisseurDto;
import com.khebli.gestiondestockproject.exception.EntityNotFoundException;
import com.khebli.gestiondestockproject.exception.ErrorCodes;
import com.khebli.gestiondestockproject.exception.InvalidEntityException;
import com.khebli.gestiondestockproject.model.*;
import com.khebli.gestiondestockproject.repository.*;
import com.khebli.gestiondestockproject.services.CommandeFournisseurService;
import com.khebli.gestiondestockproject.validator.CommandeFournisseurValidator;
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
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private ArticleRepository articleRepository;
    private FournisseurRepository fournisseurRepository;

    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, ArticleRepository articleRepository, FournisseurRepository fournisseurRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.articleRepository = articleRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("CMD fournisseur n'est pas valide",dto);
            throw  new InvalidEntityException("La Commande fournisseur n'est pas valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALIDE,errors);
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());

        if(fournisseur.isEmpty()){
            log.warn("fournisseur avec Id "+dto.getFournisseur().getId()+" n'existe pas dans la base");
            throw new EntityNotFoundException("Aucun fournisseur avec l'id "+dto.getFournisseur().getId()+"n'a été trouvé dans la BDD ", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }
        //verification des ligne commande fourniseur
        List<String> articleErrors = new ArrayList<>();
        if(dto.getLigneCommandeFournisseurs()!=null){
            dto.getLigneCommandeFournisseurs().forEach(ligneCmd->{
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

        CommandeFournisseur savedCommandeFournisseur =  commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));
        dto.getLigneCommandeFournisseurs().forEach(lgCmdclt->{
            LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(lgCmdclt);
            ligneCommandeFournisseur.setCommandeFournisseur(savedCommandeFournisseur);
            ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);

        });
        return CommandeFournisseurDto.fromEntity(savedCommandeFournisseur);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if(id==null){
            log.error("id n'existe pas");
            return null;
        }
        return commandeFournisseurRepository.findById(id).map(CommandeFournisseurDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucune Commande fournisseur avec l'ID"+id+"n'a été trouvé dans la BDD",ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeFournisseurDto findCommandeFournisseurByCode(String codeC) {
        if(!StringUtils.hasLength(codeC)){
            log.error("code cmd fournisseur est null",codeC);
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(codeC).map(CommandeFournisseurDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucune Commande fournisseur avec le code"+codeC+"n'a été trouvé dans la BDD",ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream().map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("id n'existe pas");
            return ;
        }
        commandeFournisseurRepository.deleteById(id);


    }
}
