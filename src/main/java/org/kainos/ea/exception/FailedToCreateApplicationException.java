package org.kainos.ea.exception;

public class FailedToCreateApplicationException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed to create application in the database";
    }
}
