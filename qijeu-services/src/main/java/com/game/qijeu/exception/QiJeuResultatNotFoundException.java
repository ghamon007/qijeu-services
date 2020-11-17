package com.game.qijeu.exception;

public class QiJeuResultatNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -3673976248896437772L;

    public QiJeuResultatNotFoundException(Long id) {
        super("Impossible de trouver le qijeu resultat :" + id);
    }

}
