package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.khebli.gestiondestockproject.utils.Constants.*;

@Api(COMMANDE_CLIENT_ENDPOINT)
public interface CommandeClientApi {
    @PostMapping(COMMANDE_CLIENT_ENDPOINT +"/create")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);


    @GetMapping(COMMANDE_CLIENT_ENDPOINT +"/{idCommande}")
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommande);

    @GetMapping(COMMANDE_CLIENT_ENDPOINT +"/{codeCommande}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommande") String code);

    @GetMapping(COMMANDE_CLIENT_ENDPOINT +"/all")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(COMMANDE_CLIENT_ENDPOINT +"/delete/{idCommande}")
    ResponseEntity delete(@PathVariable("idCommande") Integer id);

}
