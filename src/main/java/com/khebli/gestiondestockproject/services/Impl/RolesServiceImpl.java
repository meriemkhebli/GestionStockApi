package com.khebli.gestiondestockproject.services.Impl;

import com.khebli.gestiondestockproject.dto.RolesDto;
import com.khebli.gestiondestockproject.model.Roles;
import com.khebli.gestiondestockproject.repository.RolesRepository;
import com.khebli.gestiondestockproject.services.RolesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RolesServiceImpl implements RolesService {
    RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public RolesDto save(RolesDto dto) {
        return null;
    }

    @Override
    public RolesDto findById(Integer id) {
        return null;
    }

    @Override
    public List<RolesDto> findAll() {
        return rolesRepository.findAll().stream().map(RolesDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public RolesDto findRolesByRoleName(String roleName) {
        Roles role = rolesRepository.findByRoleName(roleName);
        return RolesDto.fromEntity(role);
    }

    @Override
    public void delete(Integer id) {

    }
}
