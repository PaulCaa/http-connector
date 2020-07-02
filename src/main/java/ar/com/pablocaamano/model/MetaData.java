package ar.com.pablocaamano.model;

import ar.com.pablocaamano.commons.rest.Error;

import java.util.LinkedList;
import java.util.List;

public class MetaData {
    private int httpStatus;
    private String message;
    private List<Error> errors;

    public MetaData(){
        errors = new LinkedList<>();
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        for (Error e : errors)
            this.errors.add(e);
    }

    public void setError(Error error) {
        this.errors.add(error);
    }


    public String toString(){
        return "{\"http_status\": " + httpStatus + ", " +
                "\"message\": " + message + ", " +
                "\"errors\": [" + errors.toString() + "]}";
    }
}
