package com.game.qijeu.exception;

public class EquipeNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 7371411586272078630L;

    public EquipeNotFoundException(Long id) {
        super("Impossible de trouver l'equipe' : " + id);
    }
}
