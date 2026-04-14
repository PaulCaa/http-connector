package ar.com.pablocaamano.exception;

/**
 * This exception is threw when any process of http connection fail
 * @author Caamaño, Pablo
 * @since 02/07/2020
 * @link pablocaamano.com.ar
 */
public class ConnectionException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Error processing http connection";

    public ConnectionException(Throwable cause){
        super(DEFAULT_MESSAGE, cause);
    }

    public ConnectionException(String message, Throwable cause){
        super(message, cause);
    }
}
