package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import static com.khebli.gestiondestockproject.utils.Constants.APP_ROOT;
import static com.khebli.gestiondestockproject.utils.Constants.UTILISATEUR_ENDPOINT;


@Api(UTILISATEUR_ENDPOINT)
public interface UtilisateurApi {
    @PostMapping(value = UTILISATEUR_ENDPOINT + "/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(UtilisateurDto dto);
    @GetMapping(value = UTILISATEUR_ENDPOINT + "/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(value = UTILISATEUR_ENDPOINT + "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findByEmail(@PathVariable("email") String login);

    @GetMapping(value = UTILISATEUR_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();
    @DeleteMapping(value = UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);

}
