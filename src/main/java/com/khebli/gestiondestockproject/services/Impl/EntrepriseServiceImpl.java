package com.khebli.gestiondestockproject.services.Impl;

import com.khebli.gestiondestockproject.dto.EntrepriseDto;
import com.khebli.gestiondestockproject.dto.RolesDto;
import com.khebli.gestiondestockproject.dto.UtilisateurDto;
import com.khebli.gestiondestockproject.exception.EntityNotFoundException;
import com.khebli.gestiondestockproject.exception.ErrorCodes;
import com.khebli.gestiondestockproject.exception.InvalidEntityException;
import com.khebli.gestiondestockproject.model.Entreprise;
import com.khebli.gestiondestockproject.repository.EntrepriseRepository;
import com.khebli.gestiondestockproject.repository.RolesRepository;
import com.khebli.gestiondestockproject.services.EntrepriseService;
import com.khebli.gestiondestockproject.services.UtilisateurService;
import com.khebli.gestiondestockproject.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;
    private UtilisateurService utilisateurService;
    private RolesRepository rolesRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, UtilisateurService utilisateurService, RolesRepository rolesRepository) {
        this.entrepriseRepository = entrepriseRepository;
        this.utilisateurService = utilisateurService;
        this.rolesRepository = rolesRepository;
    }


    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Entreprise est non valide{}", dto);
            throw new InvalidEntityException("Entrerise not valide", ErrorCodes.CATEGORIE_NOT_VALIDE, errors);
        }
        EntrepriseDto savedEntreprise = EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(dto)));
        UtilisateurDto utilisateur = fromEntreprise(savedEntreprise);
        UtilisateurDto savedUser = utilisateurService.save(utilisateur);
        RolesDto rolesDto = RolesDto.builder()
                .roleName("ADMIN")
                .utilisateur(savedUser)
                .build();
        rolesRepository.save(RolesDto.toEntity(rolesDto));
        return savedEntreprise;
    }

    private UtilisateurDto fromEntreprise(EntrepriseDto dto) {
        return UtilisateurDto.builder()
                .adresse(dto.getAdresse())
                .nom(dto.getNom())
                .prenom(dto.getCodeFiscal())
                .email((dto.getMail()))
                .motDePasse(generateRandomPassword())
                .entreprise(dto)
                .dateNaissance(Instant.now())
                .photos(dto.getPhoto())
                .build();

    }

    private String generateRandomPassword(){
        return "som3R@nd0mP@$$word";
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() -> new EntityNotFoundException("Aucune entreprise avec l'id " + id + "n'a ete trouvé", ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public EntrepriseDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Entreprise est non n'existe pas");
            throw new EntityNotFoundException("", ErrorCodes.ENTREPRISE_NOT_FOUND);
        }
        Entreprise entreprise = entrepriseRepository.findEntrepriseByNom(nom);
        return EntrepriseDto.fromEntity(entreprise);
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("id not found");
            throw new EntityNotFoundException("Aucune entreprise avec l'Id" + id + "n'a été trouvé dans la BDD", ErrorCodes.ENTREPRISE_NOT_FOUND);
        }
        entrepriseRepository.deleteById(id);

    }
}
