package ar.com.pablocaamano.service;

import ar.com.pablocaamano.commons.exception.EmptyParameterException;
import ar.com.pablocaamano.commons.rest.Error;
import ar.com.pablocaamano.model.HttpResponse;
import ar.com.pablocaamano.util.RequestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author Caamaño, Pablo
 * @since 26/05/2020
 * @link pablocaamano.com.ar
 */
public class ServiceConnector {

    private static final ObjectMapper mapper = new ObjectMapper();

    private final RequestUtils utils;
    private int statusCode = 0;
    private String message = "";
    private Error error = null;
    private Object body = null;

    public ServiceConnector(){
        this.utils = new RequestUtils();
    }

    /**
     * GET request invocation
     * @param url
     * @param params
     * @param headers
     * @return HttpResponse
     */
    public HttpResponse getRequest(String url, Map<String,String> params, Map<String,String> headers){
        if(url == null || url.equals(""))
            throw new EmptyParameterException("URL parameter is missing");
        url += utils.mapParams(params);
        return execute(url, headers);
    }

    /* GET execution */
    private HttpResponse execute(String url, Map<String,String> headers){
        try {
            HttpURLConnection httpConnection = utils.generateHttpConnection("GET",url,headers);
            httpConnection.connect();
            BufferedInputStream bs;
            statusCode = httpConnection.getResponseCode();
            if (statusCode != 200) {
                message = "ERROR";
                error = new Error();
                error.setMessage(httpConnection.getResponseMessage());
                bs = new BufferedInputStream(httpConnection.getErrorStream());
            }else {
                message = "OK";
                bs = new BufferedInputStream(httpConnection.getInputStream());
            }
            body = processInput(bs, httpConnection.getContentLength());
        }catch(Exception exception){
            statusCode = 500;
            message = "ERROR";
            error = new Error();
            error.setMessage("Internal error");
            error.setDescription("Error to process request connection");
            error.setCause(exception);
        }
        return makeResponse();
    }

    /* Method to process BufferedInputStream and return a generic object response */
    private Object processInput(BufferedInputStream bs, int contentLength) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] buff = new byte[8192];
        int len = 0;
        if(contentLength == -1){
            while((len = bs.read(buff)) != -1)
                buffer.write(buff, 0, len);
        }
        int readLen = 0;
        while((len = bs.read(buff)) != -1){
            buffer.write(buff, 0, len);
            readLen += len;
            if(readLen >= contentLength)
                break;
        }
        return mapper.readValue(buffer.toByteArray(), Object.class);
    }

    /* Making response and set all atributtes */
    private HttpResponse makeResponse(){
        HttpResponse response = new HttpResponse();
        response.getMeta().setHttpStatus(statusCode);
        response.getMeta().setMessage(message);
        if (error != null)
            response.getMeta().setError(error);
        response.setBody(body);
        return response;
    }
}
