package com.ibm.academia.apirest.exceptions.handlers;

import com.ibm.academia.apirest.exceptions.badRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UniversidadRestException
{
    @ExceptionHandler(value = badRequestException.class)
    public ResponseEntity<Object> formatoInvalidoException(badRequestException exception)
    {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        respuesta.put("error", exception.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
}
