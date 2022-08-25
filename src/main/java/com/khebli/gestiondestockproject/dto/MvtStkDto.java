package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.MvtStk;
import com.khebli.gestiondestockproject.model.TypeStkMvt;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {
    private Integer Id;

    private String code;

    private Instant dateMvt;

    private ArticleDto article;

    private TypeStkMvt typeMvt;

    private BigDecimal qteMvt;

    public static MvtStkDto fromEntity(MvtStk mvtStk){
        if(mvtStk ==null){
            return null;
        }
       return MvtStkDto.builder()
                .Id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .code(mvtStk.getCode())
                .qteMvt(mvtStk.getQteMvt())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .build();
    }
    public static MvtStk toEntity(MvtStkDto mvtStkDto){
        if(mvtStkDto ==null){
            return null;
        }
        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setCode(mvtStkDto.getCode());
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setTypeMvt((mvtStkDto.getTypeMvt()));
        mvtStk.setQteMvt(mvtStkDto.getQteMvt());
        //mvtStk.setArticle((mvtStkDto.getArticle()));
        return mvtStk;
    }
}
