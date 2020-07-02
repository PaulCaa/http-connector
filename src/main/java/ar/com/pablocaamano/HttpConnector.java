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

    /**
     * GET request with URL
     * @param url
     * @return HttpResponse
     */
    public static HttpResponse getRequest(String url){
        return getRequest(url,null,null);
    }

    /**
     * GET request with URL and path params
     * @param url
     * @param params
     * @return HttpResponse
     */
    public static HttpResponse getRequest(String url, Map<String,String> params){
        return getRequest(url,params,null);
    }

    /**
     * GET request with URL and path params and header params
     * @param url
     * @param params
     * @param headers
     * @return HttpResponse
     */
    public static HttpResponse getRequest(String url, Map<String,String> params, Map<String,String> headers){
        ServiceConnector service = new ServiceConnector();
        return service.getRequest(url, params, headers);
    }
}
