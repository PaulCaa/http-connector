package ar.com.pablocaamano;

import ar.com.pablocaamano.model.HttpResponse;
import ar.com.pablocaamano.service.ServiceConnector;

import java.util.Map;

/**
 * @author Caamaño, Pablo
 * @since 26/05/2020
 * @link pablocaamano.com.ar
 */
public class HttpConnector {

    public static HttpResponse getRequest(String url, Map<String,String> params, Map<String,String> headers){
        ServiceConnector service = new ServiceConnector();
        return service.getRequest(url, params, headers);
    }
}
