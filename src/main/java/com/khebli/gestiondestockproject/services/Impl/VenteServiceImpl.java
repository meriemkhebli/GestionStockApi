package com.khebli.gestiondestockproject.services.Impl;

import com.khebli.gestiondestockproject.dto.LigneCommandeClientDto;
import com.khebli.gestiondestockproject.dto.LigneVenteDto;
import com.khebli.gestiondestockproject.dto.VenteDto;
import com.khebli.gestiondestockproject.exception.EntityNotFoundException;
import com.khebli.gestiondestockproject.exception.ErrorCodes;
import com.khebli.gestiondestockproject.exception.InvalidEntityException;
import com.khebli.gestiondestockproject.model.Article;
import com.khebli.gestiondestockproject.model.LigneCommandeClient;
import com.khebli.gestiondestockproject.model.LigneVente;
import com.khebli.gestiondestockproject.model.Vente;
import com.khebli.gestiondestockproject.repository.ArticleRepository;
import com.khebli.gestiondestockproject.repository.LigneVenteRepository;
import com.khebli.gestiondestockproject.repository.VenteRepository;
import com.khebli.gestiondestockproject.services.VenteService;
import com.khebli.gestiondestockproject.validator.VenteValidator;
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
public class VenteServiceImpl implements VenteService {

    private VenteRepository venteRepository;
    private ArticleRepository articleRepository;
    private LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VenteServiceImpl(VenteRepository venteRepository, ArticleRepository articleRepository) {
        this.venteRepository = venteRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public VenteDto save(VenteDto dto) {
        List<String> errors = VenteValidator.Validate(dto);
        if(!errors.isEmpty()){
            log.error("");
            throw  new InvalidEntityException("Vente non valide",ErrorCodes.VENTE_NOT_VALIDE,errors);
        }
        List<String> articleErrors = new ArrayList<>();
        if(dto.getLigneVentes()!=null){
            dto.getLigneVentes().forEach(ligneVenteDto -> {
               if( ligneVenteDto.getArticle()!=null){
                   Optional<Article> article= articleRepository.findById(ligneVenteDto.getArticle().getId());
                   if(article.isEmpty()){
                       articleErrors.add("L'article avec l'ID"+ligneVenteDto.getArticle().getId()+"n'existe pas");
                   }
               }else{
                   articleErrors.add("L'article avec l'ID"+ligneVenteDto.getArticle().getId()+"n'existe pas");
               }
            });
            if(!articleErrors.isEmpty()){
                log.error("un ou plusieur article n'existe pas dans la BDD",errors);
                throw  new InvalidEntityException("Vente non valide un ou plusieur article n'existe pas dans la BDD",ErrorCodes.VENTE_NOT_VALIDE,errors);

            }
        }
          Vente venteSaved = venteRepository.save(VenteDto.toEntity(dto));
          dto.getLigneVentes().forEach(ligneVenteDto -> {
              LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
              ligneVente.setVente(venteSaved);
              ligneVenteRepository.save(ligneVente);
          });

        return VenteDto.fromEntity(venteSaved);
    }

    @Override
    public VenteDto findById(Integer id) {
        if(id==null){
            log.error("id n'existe pas");
            return  null;
        }
       return  venteRepository.findById(id).map(VenteDto::fromEntity).orElseThrow(()->new EntityNotFoundException("Aucune vente client avec l'ID"+id+ "n'a été trouvé dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VenteDto findVenteByCode(String codeV) {
        if(!StringUtils.hasLength(codeV)){
            log.error("code n'existe pas");
            return  null;

        }
        return  venteRepository.findVenteByCode(codeV).map(VenteDto::fromEntity).orElseThrow(()->new EntityNotFoundException("Aucune vente client avec le code"+codeV+ "n'a été trouvé dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public List<VenteDto> findAll() {
        return venteRepository.findAll().stream().map(VenteDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("id n'existe pas");
            return ;
        }
        venteRepository.deleteById(id);

    }
}
