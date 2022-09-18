package com.khebli.gestiondestockproject.services.Impl;


import com.khebli.gestiondestockproject.dto.UtilisateurDto;
import com.khebli.gestiondestockproject.exception.EntityNotFoundException;
import com.khebli.gestiondestockproject.exception.ErrorCodes;
import com.khebli.gestiondestockproject.exception.InvalidEntityException;
import com.khebli.gestiondestockproject.model.Utilisateur;
import com.khebli.gestiondestockproject.repository.UtilisateurRepository;
import com.khebli.gestiondestockproject.services.UtilisateurService;
import com.khebli.gestiondestockproject.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Utilisateur non valide");
            throw new InvalidEntityException("", ErrorCodes.UTILISATEUR_NOT_VALIDE, errors);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        Optional<Utilisateur> utilisateur =utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(()->new EntityNotFoundException("Aucun Utilisateur avec l'ID"+id+"n'a été trouvé dans la BDD",ErrorCodes.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        if(!StringUtils.hasLength(email)){
            log.error("email est null");
            throw  new EntityNotFoundException("",ErrorCodes.UTILISATEUR_NOT_FOUND);

        }
        Optional<Utilisateur> utilisateur = Optional.ofNullable(utilisateurRepository.findUtilisateursByLogin(email));
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(()-> new EntityNotFoundException("Aucun Utilisateur avec le email"+email+"n'a été trouvé dans la BDD",ErrorCodes.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("id n'esiste pas");
            throw new EntityNotFoundException("aucun Utilisateur avec l'ID "+id+"dans la bdd",  ErrorCodes.UTILISATEUR_NOT_FOUND);
        }
        utilisateurRepository.deleteById(id);

    }
}
