package com.matheushtz.workshop.resources.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.matheushtz.workshop.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // anotação para interceptar as exceções lançadas pelos controllers
public class ResourceExceptionHandler {

@ExceptionHandler
public ResponseEntity<StardardErrorJSON> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND; 
    StardardErrorJSON err = new StardardErrorJSON(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
 }
}
