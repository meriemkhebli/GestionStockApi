package com.khebli.gestiondestockproject.services;

import com.khebli.gestiondestockproject.dto.VenteDto;

import java.util.List;

public interface VenteService {

    VenteDto save(VenteDto dto);
    VenteDto findById(Integer id);

    VenteDto findVenteByCode(String codeC);

    List<VenteDto> findAll();

    void delete(Integer id);

}
