package com.khebli.gestiondestockproject.controller;

import com.khebli.gestiondestockproject.controller.api.MvtStkApi;
import com.khebli.gestiondestockproject.dto.MvtStkDto;
import com.khebli.gestiondestockproject.services.MvtStkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MvtController implements MvtStkApi {
    private MvtStkService mvtStkService;

    @Autowired
    public MvtController(MvtStkService mvtStkService) {
        this.mvtStkService = mvtStkService;
    }

    @Override
    public MvtStkDto save(MvtStkDto dto) {
        return mvtStkService.save(dto);
    }

    @Override
    public MvtStkDto findById(Integer id) {
        return mvtStkService.findById(id);
    }

    @Override
    public MvtStkDto findByCode(String code) {
        return mvtStkService.findByCode(code);
    }

    @Override
    public List<MvtStkDto> findAll() {
        return mvtStkService.findAll();
    }

    @Override
    public void delete(Integer id) {
        mvtStkService.delete(id);

    }
}
