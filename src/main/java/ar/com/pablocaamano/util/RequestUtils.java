package ar.com.pablocaamano.util;

import ar.com.pablocaamano.exception.ConnectionException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Utils to service process
 * @author Caamaño, Pablo
 * @since 02/07/2020
 * @link pablocaamano.com.ar
 */
public class RequestUtils {

    /***
     * Convert params in Map to string
     * @param input
     * @return String
     */
    public String mapParams(Map<String,String> input){
        return process(input);
    }

    private String process(Map<String,String> input){
        String uriParams = "";
        if(input != null){
            int size = input.size();
            if(size > 0){
                uriParams = "?";
                boolean first = true;
                for (String key : input.keySet() ) {
                    if(first) {
                        uriParams += key + "=";
                        uriParams += input.get(key);
                        first = false;
                    }else {
                        uriParams += "&" + key + "=";
                        uriParams += input.get(key);
                    }
                }
            }
        }
        return uriParams;
    }

    /**
     * Generate new HttpConnection with specific method and headers
     * @param method
     * @param url
     * @param headers
     * @return HttpURLConnection
     */
    public HttpURLConnection generateHttpConnection(String method, String url, Map<String,String> headers){
        return process(method,url,headers);
    }

    private HttpURLConnection process(String method, String strUrl, Map<String,String> headers){
        try {
            URL url = new URL(strUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod(method);
            httpConnection.setUseCaches(false);
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Accept", "*/*");
            if(headers != null && headers.size() > 0){
                for (String key : headers.keySet())
                    httpConnection.setRequestProperty(key,headers.get(key));
            }
            return httpConnection;
        }catch(Exception exception){
            throw new ConnectionException(exception);
        }
    }
}
