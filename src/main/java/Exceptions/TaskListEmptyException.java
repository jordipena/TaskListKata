package Exceptions;

public class TaskListEmptyException extends RuntimeException {
    public TaskListEmptyException(String message) {
        super(message);
    }
}
