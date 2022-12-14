package com.khebli.gestiondestockproject.exception;

public enum ErrorCodes {
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALIDE(1001),

    CATEGORIE_NOT_FOUND(2000),
    CATEGORIE_NOT_VALIDE(2001),

    CLIENT_NOT_FOUND(3000),
    CLIENT_NOT_VALIDE(3001),


    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_CLIENT_NOT_VALIDE(4001),

    COMMANDE_FOURNISSEUR_NOT_FOUND(5000),
    COMMANDE_FOURNISSEUR_NOT_VALIDE(5001),

    ENTREPRISE_NOT_FOUND(6000),
    ENTREPRISE_NOT_VALIDE(6001),


    FOURNISSEUR_NOT_FOUND(7000),
    FOURNISSEUR_NOT_VALIDE(7001),

    LIGNE_COMMANDE_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMANDE_CLIENT_NOT_VALIDE(8001),

    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND(9000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_VALIDE(9001),

    LIGNE_VENTE_NOT_FOUND(10000),
    LIGNE_VENTE_NOT_VALIDE(10001),


    MVT_STK_NOT_FOUND(11000),
    MVT_STK_NOT_VALIDE(11001),

    UTILISATEUR_NOT_FOUND(12000),
    UTILISATEUR_NOT_VALIDE(12001),

    VENTE_NOT_FOUND(13000),
    VENTE_NOT_VALIDE(13001),
    BAD_CREDENTIALS(987)
            ;
    private int code;
    ErrorCodes(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }
}
