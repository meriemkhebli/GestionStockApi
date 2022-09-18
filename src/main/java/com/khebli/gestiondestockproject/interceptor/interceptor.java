package com.khebli.gestiondestockproject.interceptor;

import org.hibernate.EmptyInterceptor;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

/*on ne veut pas modifier les repository pour interroger la base par identreprise, o, creer un intercepteur
entre la base et le repository
* */

public class interceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
        if(StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")  && !sql.toLowerCase().contains("select nextval")){

            /*recuperer le nom de la table*/
          final String entityName = sql.substring(7,sql.indexOf("."));
            /*recuperer l'id entreprise avec MCT.get*/

            final String idEntreprise = MDC.get("idEntreprise");

          if(StringUtils.hasLength(entityName)

                  /*dans entreprise et role on a pas idEntreprise*/
                  && !entityName.toLowerCase().contains("entreprise")
                  && !entityName.toLowerCase().contains("roles")

                  /*verifier l'inentrprise non null*/
                  && StringUtils.hasLength(idEntreprise))

            if(sql.contains("where")){
                sql= sql + " and "+ entityName + ".idEntreprise " +idEntreprise;
            }else{
                sql= sql + " where "+ entityName + ".idEntreprise " +idEntreprise;
            }
        }
        return super.onPrepareStatement(sql);
    }
}
