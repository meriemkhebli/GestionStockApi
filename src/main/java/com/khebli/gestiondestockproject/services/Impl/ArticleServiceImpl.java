package com.khebli.gestiondestockproject.services.Impl;

import com.khebli.gestiondestockproject.dto.ArticleDto;
import com.khebli.gestiondestockproject.exception.EntityNotFoundException;
import com.khebli.gestiondestockproject.exception.ErrorCodes;
import com.khebli.gestiondestockproject.exception.InvalidEntityException;
import com.khebli.gestiondestockproject.model.Article;
import com.khebli.gestiondestockproject.repository.ArticleRepository;
import com.khebli.gestiondestockproject.services.ArticleService;
import com.khebli.gestiondestockproject.validator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Clock;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService {
    ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl( ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors =ArticleValidator.validate(dto);
        if(!errors.isEmpty()){
            System.out.println("Article est non valide{}: " + dto);
         //   log.error("Article est non valide{}",dto);
            throw new InvalidEntityException("Article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALIDE,errors);
        }

        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id==null){
            System.out.println("ID Article est null: " );
            //  log.error("Article ID is null");
            return null;
        }
        Optional<Article> article= articleRepository.findById(id);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->new EntityNotFoundException("Aucun article avec l'Id"+id+"n'a été trouvé dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)){
            System.out.println("Article code est null: " );
          //  log.error("Articl code  is null");
            return null;
        }
        Optional<Article> article= articleRepository.findArticleByCodeArticle(codeArticle);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->new EntityNotFoundException("Aucun article avec le code"+codeArticle+"n'a été trouvé dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id ==null){
            return;
        }
        articleRepository.deleteById(id);

    }
}
