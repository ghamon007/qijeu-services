package com.game.qijeu.exception;

public class QiJeuNotFoundException extends RuntimeException {

 
    /**
     *
     */
    private static final long serialVersionUID = -6413721002699333593L;

    public QiJeuNotFoundException(Long id) {
        super("Impossible de trouver le QiJeu : " + id);
    }
}
