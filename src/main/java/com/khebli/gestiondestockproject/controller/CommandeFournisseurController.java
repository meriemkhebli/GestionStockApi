package com.khebli.gestiondestockproject.controller;

import com.khebli.gestiondestockproject.controller.api.CommandeFournisseurApi;
import com.khebli.gestiondestockproject.dto.CommandeFournisseurDto;
import com.khebli.gestiondestockproject.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    private CommandeFournisseurService commandeFournisseurService;

    @Autowired
    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> save(CommandeFournisseurDto dto) {
        return ResponseEntity.ok(commandeFournisseurService.save(dto));
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> findById(Integer idCommande) {
        return ResponseEntity.ok(commandeFournisseurService.findById(idCommande));
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> findByCode(String code) {
        return ResponseEntity.ok(commandeFournisseurService.findCommandeFournisseurByCode(code));
    }

    @Override
    public ResponseEntity<List<CommandeFournisseurDto>> findAll() {
        return ResponseEntity.ok(commandeFournisseurService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        commandeFournisseurService.delete(id);
        return ResponseEntity.ok().build();    }
}
