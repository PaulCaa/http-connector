package ar.com.pablocaamano.model;

/**
 * Main response. This class contains http communication results
 * in meta data and raw response in the body.
 * @author Caamaño, Pablo
 * @since 02/07/2020
 * @link pablocaamano.com.ar
 */
public class HttpResponse {

    private MetaData meta;
    private Object body;

    public HttpResponse(){
        meta = new MetaData();
    }

    public MetaData getMeta() {
        return meta;
    }

    public void setMeta(MetaData meta) {
        this.meta = meta;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String toString(){
        return "{\"meta\": " + meta.toString() + "," +
                "\"body\": " + body.toString() + "}";
    }
}
