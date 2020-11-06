package com.game.qijeu.exception;

public class QiJeuResultatNotFoundException extends RuntimeException {
    
    public QiJeuResultatNotFoundException(Long id){
        super("Impossible de trouver le qijeu resultat :"+id);
    }

}
