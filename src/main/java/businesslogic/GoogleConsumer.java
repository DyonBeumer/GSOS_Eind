//package businesslogic;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;;

import java.io.IOException;

public class GoogleConsumer {
    private static String url = "https://maps.googleapis.com/maps/api/geocode/json?";
    private static String key = "AIzaSyAZm3KQ8kbZkw2Cu6TYovuMx9_G4wXcVco";


    public static String aquireGeometry(String adress) throws IOException, JSONException {
        String tempurl = url + "address=" + adress + "&key="+key;
        System.out.println(tempurl);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(tempurl);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        try{
            System.out.println(response1.getStatusLine());
            HttpEntity entity = response1.getEntity();
            String content = EntityUtils.toString(entity);

            JSONObject obj = new JSONObject(content);
            JSONArray result = obj.getJSONArray("results");
            JSONObject geometry = result.getJSONObject(0);
            System.out.println(geometry.getJSONObject("geometry").getJSONObject("location").getDouble("lat"));


            EntityUtils.consume(entity);
        }
        finally {
            response1.close();
        }
        return "ARJANISGAY";
    }


}