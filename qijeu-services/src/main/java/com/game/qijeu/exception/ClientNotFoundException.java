package com.game.qijeu.exception;

public class ClientNotFoundException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 5064523209003175458L;

    public ClientNotFoundException(Long id) {
        super("Impossible de trouver le client : " + id);
      }
}
