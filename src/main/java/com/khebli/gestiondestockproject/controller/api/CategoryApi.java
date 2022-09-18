package com.khebli.gestiondestockproject.controller.api;

import com.khebli.gestiondestockproject.dto.CategoryDto;
import com.khebli.gestiondestockproject.model.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.khebli.gestiondestockproject.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categorie")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT+"/categorie/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer une category(Ajouter /Modifier)", notes = "Cette methode permet d'enregistrer ou modifier une category", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet category cree /modifie"),
            @ApiResponse(code = 400, message = "L'objet category n'est pas validé")

    })
    CategoryDto save(CategoryDto dto);

    @GetMapping(value = APP_ROOT+"/categorie/{IdCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un category par son id", notes = "Cette methode permet chercher une category par son ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La category a été trouvé"),
            @ApiResponse(code = 404, message = "Aucune category n'a été trouvé")

    })
    CategoryDto findById(@PathVariable("IdCategorie") Integer id);

    @GetMapping(value = APP_ROOT +"/categorie/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des category", notes = "Cette methode permet chercher et envoyer la liste des category de la BDD",
            responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des category/ Une liste vide")
    })
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT +"/categorie/delete/{IdCategorie}")
    @ApiOperation(value = "Supprimer une category", notes = "Cette methode permet de supprimer un  category par son ID",
            response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La category à été supprimé avec succes")
    })
    void delete(@PathVariable("IdCategorie") Integer id);

    @DeleteMapping(value = APP_ROOT +"categorie/delete/")
    void delete(Category dto);

    @GetMapping(value = APP_ROOT+"/categorie/{codeCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un category", notes = "Cette methode permet chercher une category par son Code", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La category à été trouvé"),
            @ApiResponse(code = 404, message = "Aucun category n'a été trouvé")

    })
    CategoryDto findByCodeCategory(@PathVariable("codeCategorie") String codeCategory);

    @GetMapping(value = APP_ROOT+"/categorie/{codeCategorie}/{designationCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un category", notes = "Cette methode permet chercher une category par son Code, par designation", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La category à été trouvé"),
            @ApiResponse(code = 404, message = "Aucun category n'a été trouvé")

    })
    CategoryDto findByCodeByDesCategory(@PathVariable("codeCategorie")String code, @PathVariable("designationCategorie")String designation);
}
