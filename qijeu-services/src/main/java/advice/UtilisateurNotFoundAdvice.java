package advice;

import com.game.qijeu.exception.ClientNotFoundException;
import com.game.qijeu.exception.UtilisateurNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UtilisateurNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String utilisateurNotFoundHandler(UtilisateurNotFoundException ex) {
      return ex.getMessage();
    }
}
