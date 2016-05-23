package businesslogic;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;

public class GoogleConsumer {
    private static String url = "https://maps.googleapis.com/maps/api/geocode/json?";
    private static String key = "AIzaSyAZm3KQ8kbZkw2Cu6TYovuMx9_G4wXcVco";


    public static String aquireGeometry(String adress) throws IOException, JSONException {
        String latlongurl = url + "address=" + adress + "&key="+key;

        System.out.println(latlongurl);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(latlongurl);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);

        try{
            System.out.println(response1.getStatusLine());
            HttpEntity entity = response1.getEntity();
            String content = EntityUtils.toString(entity);

            JSONObject obj = new JSONObject(content);
            JSONArray result = obj.getJSONArray("results");
            JSONObject geometry = result.getJSONObject(0);
            double lat = (double) geometry.getJSONObject("geometry")
                    .getJSONObject("location").get("lat");
            double lng = (double) geometry.getJSONObject("geometry")
                    .getJSONObject("location").get("lng");
            System.out.println(lat);


            String postcodeurl = url + "latlng=" + lat + ","+ lng + "&key="+key;
            System.out.println(postcodeurl);
            CloseableHttpClient httpclient2 = HttpClients.createDefault();
            HttpGet httpGet2 = new HttpGet(postcodeurl);
            CloseableHttpResponse response2 = httpclient2.execute(httpGet2);
            try{
                System.out.println(response2.getStatusLine());
                HttpEntity entity1 = response2.getEntity();
                String content1 = EntityUtils.toString(entity1);

                JSONObject obj1 = new JSONObject(content1);
                JSONArray result1 = obj1.getJSONArray("results");
                int postal = Integer.parseInt((String)result1.getJSONObject(0).getJSONArray("address_components").getJSONObject(7).get("short_name"));
                System.out.println(postal);
                EntityUtils.consume(entity1);
            }
            finally {
                response2.close();
            }

           // System.out.println(lat);
           // System.out.println(lng);


            EntityUtils.consume(entity);
        }
        finally {
            response1.close();
        }
        return "ARJANISGAY";
    }


}