package com.khebli.gestiondestockproject.controller;

import com.khebli.gestiondestockproject.controller.api.VenteApi;
import com.khebli.gestiondestockproject.dto.VenteDto;
import com.khebli.gestiondestockproject.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenteController implements VenteApi {

    private VenteService venteService;

    @Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @Override
    public VenteDto save(VenteDto dto) {
        return venteService.save(dto);
    }

    @Override
    public VenteDto findById(Integer id) {
        return venteService.findById(id);
    }

    @Override
    public VenteDto findVenteByCode(String codeVente) {
        return venteService.findVenteByCode(codeVente);
    }

    @Override
    public List<VenteDto> findAll() {
        return venteService.findAll();
    }

    @Override
    public void delete(Integer id) {
        venteService.delete(id);

    }
}
