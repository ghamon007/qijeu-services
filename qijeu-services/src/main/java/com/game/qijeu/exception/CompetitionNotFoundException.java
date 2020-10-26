package com.game.qijeu.exception;

public class CompetitionNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 7371411586272078630L;

    public CompetitionNotFoundException(Long id) {
        super("Impossible de trouver la competition : " + id);
    }
}
