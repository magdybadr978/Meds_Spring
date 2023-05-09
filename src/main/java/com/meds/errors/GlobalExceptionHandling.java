package com.meds.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    // To Handle Any Error
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Server Error", details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // To Handle Not Found Error
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(Exception ex, WebRequest request) {
        List<String> detalis = new ArrayList<>();
        detalis.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record not found ", detalis);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // To Handle Any Validation Error
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ForbiddenException.class)
    public final ResponseEntity<ErrorResponse> handleForbiddenException(Exception ex, WebRequest request) {
        List<String> detalis = new ArrayList<>();
        detalis.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Forbidden", detalis);
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(UnauthorizedException.class)
    public final ResponseEntity<ErrorResponse> handleUnauthorizedException(Exception ex, WebRequest request) {
        List<String> detalis = new ArrayList<>();
        detalis.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Unauthorized", detalis);
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
