package ar.com.pablocaamano;

import ar.com.pablocaamano.service.ServiceConnector;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

/**
 *
 * @Author Caamaño, Pablo
 * @Since 26/05/2020
 */
public class HttpConnector {

    private HttpMethod method;
    private String host = "";
    private String uriPath = "";
    private HttpHeaders headers;
    private Object request;
    private ServiceConnector serviceConnector;

    private HttpConnector(){
        this.serviceConnector = new ServiceConnector();
        this.method = HttpMethod.GET;
        this.host = "http://localhost:8080";
        this.headers = new HttpHeaders();
    }

    public static HttpConnector connect(){
        return new HttpConnector();
    }

    public HttpConnector withMethod(HttpMethod method){
        this.method = method;
        return this;
    }

    public HttpConnector withHost(String host){
        this.host = host;
        return this;
    }

    public HttpConnector withUriPath(String uriPath){
        this.uriPath = uriPath;
        return this;
    }

    public HttpConnector withHeader(String key, String value){
        this.headers.add(key, value);
        return this;
    }

    public HttpConnector withRequestBody(Object request){
        this.request = request;
        return this;
    }

    public Object run(){
        return serviceConnector.connect(method, host + uriPath, headers, request);
    }
}
