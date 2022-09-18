package com.khebli.gestiondestockproject.services;

import com.khebli.gestiondestockproject.dto.RolesDto;

import java.util.List;

public interface RolesService {

    RolesDto save(RolesDto dto);

    RolesDto findById(Integer id);
    List<RolesDto> findAll();
    RolesDto findRolesByRoleName(String code);
    void delete (Integer id);
}
