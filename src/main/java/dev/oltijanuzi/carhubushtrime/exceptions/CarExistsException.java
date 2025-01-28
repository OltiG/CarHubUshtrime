package dev.oltijanuzi.carhubushtrime.exceptions;

public class CarExistsException extends RuntimeException {
    public CarExistsException(String message) {
        super(message);
    }
    public CarExistsException(){
        super("Car already exists");
    }
}
