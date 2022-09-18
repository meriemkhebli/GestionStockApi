package com.khebli.gestiondestockproject.utils;

public interface Constants {
    public static String APP_ROOT = "/gestionstock/v1";
    String COMMANDE_FOURNISSEUR_ENDPOINT = APP_ROOT + "/commandeFourniseurs";
    String COMMANDE_CLIENT_ENDPOINT = APP_ROOT + "/commandeClients";
    String CLIENT_ENDPOINT = APP_ROOT + "/clients";
    String FOURNISSEUR_ENDPOINT = APP_ROOT + "/fournisseurs";
    String ENTREPRISE_ENDPOINT =APP_ROOT +"/entreprises";
    String UTILISATEUR_ENDPOINT = APP_ROOT + "/utilisateurs";
    String VENTE_ENDPOINT = APP_ROOT + "/ventes";

    String MVT_ENDPOINT = APP_ROOT + "Mvts";
    String AUTHENTICATION_ENDPOINT  = APP_ROOT + "/authentication";

    String AUTHORIZATION_HEADER = "Autorization";

}
