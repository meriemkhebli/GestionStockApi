package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import static com.khebli.gestiondestockproject.utils.Constants.APP_ROOT;
import static com.khebli.gestiondestockproject.utils.Constants.ENTREPRISE_ENDPOINT;


import java.util.List;

@Api(ENTREPRISE_ENDPOINT)
public interface EntrepriseApi {
    @PostMapping(value = ENTREPRISE_ENDPOINT +"/create" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(EntrepriseDto dto);
    @GetMapping(value =  ENTREPRISE_ENDPOINT +"/{idEntreprise}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);
    @GetMapping(value = ENTREPRISE_ENDPOINT +"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();
    @GetMapping(value = ENTREPRISE_ENDPOINT +"/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByNom(@PathVariable("nom") String nom);
    @DeleteMapping(value= ENTREPRISE_ENDPOINT + "/delete/{idEntreprise}")
    void delete(@PathVariable("idEntreprise") Integer id);
}
