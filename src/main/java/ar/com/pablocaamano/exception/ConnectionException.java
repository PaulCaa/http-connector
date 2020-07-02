package ar.com.pablocaamano.exception;

import ar.com.pablocaamano.commons.exception.CommonException;

/**
 * This exception is throwed when any process of http connection fail
 * @Author Caamaño, Pablo
 * @Since 02/07/2020
 * @Website pablocaamano.com.ar
 */
public class ConnectionException extends CommonException {

    private static final String DEFAULT_MESSAGE = "Error processing http connection";

    public ConnectionException(Throwable cause){
        super(DEFAULT_MESSAGE, cause);
    }

    public ConnectionException(String message, Throwable cause){
        super(message, cause);
    }
}
