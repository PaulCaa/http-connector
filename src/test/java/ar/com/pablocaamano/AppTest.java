package ar.com.pablocaamano;

import ar.com.pablocaamano.model.HttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue(){
        assertTrue( true );
    }

    @Test
    public void testGetRequest1(){
        Map<String,String> params = new HashMap<>();
        params.put("callback","paulcaa");
        HttpResponse response = HttpConnector.getRequest("https://api.imgur.com/3/gallery.json", params);
        Assert.assertNotNull(response);
    }

    @Test
    public void testGetRequest2(){
        HttpResponse response = HttpConnector.getRequest("https://mobilepx.icbc.com.ar/icbc/res/update?clientVersion=59");
        Assert.assertNotNull(response);
    }
}
