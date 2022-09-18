package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.khebli.gestiondestockproject.utils.Constants.*;


@Api(COMMANDE_FOURNISSEUR_ENDPOINT)
public interface CommandeFournisseurApi {

    @PostMapping(COMMANDE_FOURNISSEUR_ENDPOINT +"/create")
    ResponseEntity<CommandeFournisseurDto> save(@RequestBody CommandeFournisseurDto dto);


    @GetMapping(COMMANDE_FOURNISSEUR_ENDPOINT+ "/{idCommande}")
    ResponseEntity<CommandeFournisseurDto> findById(@PathVariable Integer idCommande);

    @GetMapping(COMMANDE_FOURNISSEUR_ENDPOINT +"/{codeCommande}")
    ResponseEntity<CommandeFournisseurDto> findByCode(@PathVariable("codeCommande") String code);

    @GetMapping(COMMANDE_FOURNISSEUR_ENDPOINT +"/all")
    ResponseEntity<List<CommandeFournisseurDto>> findAll();

    @DeleteMapping(COMMANDE_FOURNISSEUR_ENDPOINT +"/delete/{idCommande}")
    ResponseEntity delete(@PathVariable("idCommande") Integer id);

}
