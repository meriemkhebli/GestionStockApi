package com.khebli.gestiondestockproject.dto;

import com.khebli.gestiondestockproject.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolesDto {
    private Integer Id;
    private String roleName;

    private UtilisateurDto utilisateur;
    public static RolesDto fromEntity(Roles roles){
        if(roles ==null){
            return null;
        }
        return RolesDto.builder()
                .Id(roles.getId())
                .roleName(roles.getRoleName())
                .utilisateur(UtilisateurDto.fromEntity(roles.getUtilisateur()))
                .build();

    }
    public static Roles toEntity(RolesDto rolesDto){

        if(rolesDto ==null){
            return null;
        }
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());
      //  roles.setUtilisateur(rolesDto.getUtilisateur());

        return roles;
    }


}
