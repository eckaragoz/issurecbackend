package com.isrc.configurations;

import com.isrc.exceptions.Exceptions;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
  @ExceptionHandler(Exceptions.class)
  public ResponseEntity<Object> handleUserNotFoundException(Exceptions ex, WebRequest request)
  {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", ex.toString());
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }



}
