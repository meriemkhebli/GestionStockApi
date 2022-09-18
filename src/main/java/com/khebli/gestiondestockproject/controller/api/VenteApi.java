package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.VenteDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.khebli.gestiondestockproject.utils.Constants.UTILISATEUR_ENDPOINT;
import static com.khebli.gestiondestockproject.utils.Constants.VENTE_ENDPOINT;

@Api(VENTE_ENDPOINT)
public interface VenteApi {

    @PostMapping(value = VENTE_ENDPOINT + "/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    VenteDto save(@RequestBody VenteDto dto);
    @GetMapping(value = VENTE_ENDPOINT + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto findById(@PathVariable Integer id);

    @GetMapping(value = VENTE_ENDPOINT + "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto findVenteByCode(@PathVariable("code") String codeVente);

    @GetMapping(value = VENTE_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<VenteDto> findAll();

    @DeleteMapping(value = VENTE_ENDPOINT + "/delete/{id}")
    void delete(@PathVariable Integer id);

}
