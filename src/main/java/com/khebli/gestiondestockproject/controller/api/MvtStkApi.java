package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.MvtStkDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.khebli.gestiondestockproject.utils.Constants.FOURNISSEUR_ENDPOINT;
import static com.khebli.gestiondestockproject.utils.Constants.MVT_ENDPOINT;

@Api(MVT_ENDPOINT)
public interface MvtStkApi {

    @PostMapping(value = MVT_ENDPOINT +"/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    MvtStkDto save(@RequestBody MvtStkDto dto);

    @GetMapping(value = MVT_ENDPOINT + "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    MvtStkDto findById(@PathVariable Integer id);

    @GetMapping(MVT_ENDPOINT +"/{code}")
    MvtStkDto findByCode(@PathVariable("code") String code);

    @GetMapping(value = MVT_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MvtStkDto> findAll();

    @DeleteMapping(value = MVT_ENDPOINT + "/delete/{id}")
    void delete(@PathVariable("id") Integer id);
}
