package src.businesslogic;

import java.net.URL;

public class WeatherConsumer {
    private static String url = "api.openweathermap.org/data/2.5/weather?";
    private static String key = "45f11f8c4e48c92c287cc43cf2fe8f7e";


    public JSON aquireWeather(String lat, String lon) {

        String tempurl = url + "lat=" + lat + "&lon=" + lon;
        URL test = new URL(tempurl);
//
    }
}