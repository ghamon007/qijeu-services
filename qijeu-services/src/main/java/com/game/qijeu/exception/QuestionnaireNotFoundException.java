package com.game.qijeu.exception;

public class QuestionnaireNotFoundException extends RuntimeException {
    
    public QuestionnaireNotFoundException(Long id){
        super("Impossible de trouver le questionnaire id : "+id);
    }
}
