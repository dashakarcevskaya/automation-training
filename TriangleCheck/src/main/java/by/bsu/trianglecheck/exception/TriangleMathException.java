package by.bsu.trianglecheck.exception;

public class TriangleMathException extends RuntimeException {
    public TriangleMathException() { super(); }

    public TriangleMathException(String message) {
        super(message);
    }

    public TriangleMathException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleMathException(Throwable cause) {
        super(cause);
    }
}
