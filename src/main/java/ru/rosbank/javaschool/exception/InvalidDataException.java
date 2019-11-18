package ru.rosbank.javaschool.exception;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException(String msg){
        super(msg);
    }
    public InvalidDataException(Throwable reason) {
        super (reason);

    }

}
