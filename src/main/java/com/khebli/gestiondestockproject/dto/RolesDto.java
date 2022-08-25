package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
    private Integer Id;
    private String code;
    private UtilisateurDto utilisateur;
    public static RolesDto fromEntity(Roles roles){
        if(roles ==null){
            return null;
        }
        return RolesDto.builder()
                .Id(roles.getId())
                .code(roles.getCode())
                .utilisateur(UtilisateurDto.fromEntity(roles.getUtilisateur()))
                .build();

    }
    public static Roles toEntity(RolesDto rolesDto){

        if(rolesDto ==null){
            return null;
        }
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setCode(rolesDto.getCode());
      //  roles.setUtilisateur(rolesDto.getUtilisateur());

        return roles;
    }


}
