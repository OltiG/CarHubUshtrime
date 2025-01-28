package dev.oltijanuzi.carhubushtrime.exceptions;

public class UnauthorizedRoleChangeException extends RuntimeException {
    public UnauthorizedRoleChangeException(String message) {
        super(message);
    }
}
