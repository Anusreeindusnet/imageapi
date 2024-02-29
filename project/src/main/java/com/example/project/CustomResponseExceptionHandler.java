//package com.example.project;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.ErrorResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//
//@ControllerAdvice
//@RestController
//public class CustomResponseExceptionHandler {
//
//    @ExceptionHandler(PersonNotFoundException.class)
//    public final ResponseEntity<PersonErrorResponse> handlePersonNotFoundException(PersonNotFoundException ex) {
//        PersonErrorResponse error = new PersonErrorResponse();
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(ex.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//    }
