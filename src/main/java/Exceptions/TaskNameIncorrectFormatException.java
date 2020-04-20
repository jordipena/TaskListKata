package Exceptions;

public class TaskNameIncorrectFormatException extends RuntimeException {
    public TaskNameIncorrectFormatException(String message) {
        super(message);
    }
}
