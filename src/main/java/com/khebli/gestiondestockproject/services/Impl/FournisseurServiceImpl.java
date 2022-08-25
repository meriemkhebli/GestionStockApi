package com.khebli.gestiondestockproject.services.Impl;

import com.khebli.gestiondestockproject.dto.FournisseurDto;
import com.khebli.gestiondestockproject.exception.EntityNotFoundException;
import com.khebli.gestiondestockproject.exception.ErrorCodes;
import com.khebli.gestiondestockproject.model.Fournisseur;
import com.khebli.gestiondestockproject.repository.FournisseurRepository;
import com.khebli.gestiondestockproject.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        Fournisseur fournisseurSaved = fournisseurRepository.save(FournisseurDto.toEntity(dto));
        return FournisseurDto.fromEntity(fournisseurSaved);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(()->new EntityNotFoundException("Aucun fournisseur avec l'Id"+id+"n'a été trouvé dans la BDD", ErrorCodes.FOURNISSEUR_NOT_FOUND));

    }
    @Override
    public FournisseurDto findFournisseurByNom(String nomFournisseur) {
        Fournisseur fournisseur = fournisseurRepository.findFournisseurByNom(nomFournisseur);

        return FournisseurDto.fromEntity(fournisseur);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        fournisseurRepository.deleteById(id);

    }
}
