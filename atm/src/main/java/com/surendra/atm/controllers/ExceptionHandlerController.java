package com.surendra.atm.controllers;

import com.surendra.atm.exceptions.TransactionException;
import com.surendra.atm.exceptions.UnauthorizedException;
import com.surendra.atm.model.Status;
import com.surendra.atm.model.StatusFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Status> handleUnauthorizedException(final UnauthorizedException e) {
        Status failStatus = StatusFactory.getFailStatus();
        failStatus.setStatusMessage("Invalid access to account");
        return new ResponseEntity<>(failStatus, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<Status> handleTransactionException(final TransactionException e) {
        Status failStatus = StatusFactory.getFailStatus();
        failStatus.setStatusMessage(e.getReason());
        return new ResponseEntity<>(failStatus, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Status> handleException(final Exception e) {
        e.printStackTrace();
        Status failStatus = StatusFactory.getFailStatus();
        failStatus.setStatusMessage(e.getMessage());
        return new ResponseEntity<>(failStatus, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
