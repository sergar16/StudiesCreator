package exceptions;

/**
 * Created by Logitech on 11.06.15.
 */
public class InvalidJSONException extends RuntimeException{
    public InvalidJSONException() {
    }

    public InvalidJSONException(String message) {
        super(message);
    }

    public InvalidJSONException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidJSONException(Throwable cause) {
        super(cause);
    }

    public InvalidJSONException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
