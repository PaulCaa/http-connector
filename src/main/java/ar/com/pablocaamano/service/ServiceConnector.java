package ar.com.pablocaamano.service;

import ar.com.pablocaamano.commons.rest.RestRequest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

public class ServiceConnector {

    private HttpStatus httpStatus;
    private RestTemplate restTemplate;

    public ServiceConnector(){
        this.restTemplate = new RestTemplate();
    }

    /**
     * Method to build restTemplate and call service
     * @param httpMethod
     * @param url
     * @param httpHeaders
     * @param request
     * @return
     */
    private Object httpConnection(HttpMethod httpMethod, String url, HttpHeaders httpHeaders, Object request){
        // wrap request
        RestRequest restRequest = makeRequest(request);
        // add media type to headers
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // make http entity
        HttpEntity<RestRequest> httpEntity = new HttpEntity<>(restRequest,httpHeaders);
        // rest comunication
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, httpMethod, httpEntity, Object.class);
        this.httpStatus = responseEntity.getStatusCode();
        return responseEntity.getBody();
    }

    private RestRequest makeRequest(Object request){
        RestRequest restRequest = (RestRequest) request;
        return restRequest;
    }

    public Object connect(HttpMethod httpMethod, String url, HttpHeaders httpHeaders, Object request){
        return httpConnection(httpMethod,url,httpHeaders,request);
    }

    public HttpStatus getHttpStatus(){
        return this.httpStatus;
    }
}
