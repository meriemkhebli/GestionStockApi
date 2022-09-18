package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.ClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.khebli.gestiondestockproject.utils.Constants.APP_ROOT;
import static com.khebli.gestiondestockproject.utils.Constants.CLIENT_ENDPOINT;

@Api(CLIENT_ENDPOINT)
public interface ClientApi {
    @PostMapping(value = CLIENT_ENDPOINT +"/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(value = CLIENT_ENDPOINT + "{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idClient") Integer id);

    @GetMapping(value = CLIENT_ENDPOINT + "/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findByNom(@PathVariable("nom") String nomClient);

    @GetMapping(value = CLIENT_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @DeleteMapping(value = CLIENT_ENDPOINT + "/delete/{id}")
    void delete(@PathVariable Integer id);
}
