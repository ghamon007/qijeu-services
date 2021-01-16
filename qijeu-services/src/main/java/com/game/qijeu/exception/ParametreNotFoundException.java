package com.game.qijeu.exception;

public class ParametreNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 8214500692903458698L;

    public ParametreNotFoundException(Long id) {
        super("Impossible de trouver le parametre : " + id);
    }

    public ParametreNotFoundException(String code) {
        super("Impossible de trouver le parametre : " + code);
    }

}
