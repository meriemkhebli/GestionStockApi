package com.khebli.gestiondestockproject.services;

import com.khebli.gestiondestockproject.dto.ArticleDto;
import com.khebli.gestiondestockproject.dto.MvtStkDto;

import java.util.List;

public interface MvtStkService {
    MvtStkDto save(MvtStkDto dto);

    MvtStkDto findById(Integer id);

    MvtStkDto findByCode(String code);

    List<MvtStkDto> findAll();

    void delete(Integer id);
}
