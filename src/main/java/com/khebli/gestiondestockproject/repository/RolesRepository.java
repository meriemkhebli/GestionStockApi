package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.Article;
import com.khebli.gestiondestockproject.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles,Integer> {

    @Query("Select r from Roles r where r.roleName= :nameRole")
    Roles findByRoleName(@Param("nameRole") String nameRole);

}
