package online.niyv0708.exception;

public class ClazzHasStudentsException extends RuntimeException{
    public ClazzHasStudentsException() {
        super();
    }
    public ClazzHasStudentsException(String message) {
        super(message);
    }
}
