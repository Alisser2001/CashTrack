package com.alidev.cashtrack.exception;
import org.springframework.dao.DataAccessException;

public class RepositoryException extends Exception{
    public RepositoryException(String message) {
        super(message);
    }
    public RepositoryException(String message, DataAccessException e) {
        super(message);
    }
}
