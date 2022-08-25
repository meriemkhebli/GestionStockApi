package com.khebli.gestiondestockproject.repository;

import com.khebli.gestiondestockproject.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Integer> {

//requette jpql
    @Query("Select a from Article a where a.codeArticle = :code and a.designation = :designation")
    List<Article>  findByCostumQuery(@Param("code") String c,@Param("designation") String d);

    //requette native
    @Query(value = "select * from article where code = :code",nativeQuery = true)
    List<Article> findByCostumNativeQuery(@Param("code") String c);

    Optional<Article> findArticleByCodeArticle(String codeArticle);


}
