package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.FournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.khebli.gestiondestockproject.utils.Constants.*;


@Api(FOURNISSEUR_ENDPOINT)
public interface FournisseurApi {

    @PostMapping(value = FOURNISSEUR_ENDPOINT +"/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(value = FOURNISSEUR_ENDPOINT + "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable Integer id);

    @GetMapping(FOURNISSEUR_ENDPOINT +"/{nomFournisseur}")
    FournisseurDto findFournisseurByNom(@PathVariable String nomFournisseur);

    @GetMapping(value = FOURNISSEUR_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @DeleteMapping(value = FOURNISSEUR_ENDPOINT + "/delete/{id}")
    void delete (@PathVariable Integer id);

}
