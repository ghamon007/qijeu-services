package com.game.qijeu.exception;

public class UtilisateurNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 7371411586272078630L;

    public UtilisateurNotFoundException(String login, String password) {
        super("Impossible de trouver l'utilisateur : " + login+ ", mot de passe : "+password);
    }

    public UtilisateurNotFoundException(String login) {
        super("Impossible de trouver l'utilisateur : " + login);
    }

    public UtilisateurNotFoundException(Long id) {
        super("Impossible de trouver l'utilisateur id : " + id);
    }

}
