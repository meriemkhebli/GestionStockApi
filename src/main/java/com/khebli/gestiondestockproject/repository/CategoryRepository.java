package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {



    @Query(value = "Select * from Categorie where code = :code and designation =:designation ", nativeQuery = true)
    List<Category> findCategoryByCodeByDesignationlist(@Param("code") String c,@Param("designation") String d );

    @Query(value = "Select * from Categorie where code = :code and designation =:designation ", nativeQuery = true)
    Category findCategoryByCodeByDesignation(@Param("code") String c,@Param("designation") String d );

    @Query(value = "Select * from Categorie where code = :code", nativeQuery = true)
    Category findCategoryByCode(@Param("code") String c );

}
