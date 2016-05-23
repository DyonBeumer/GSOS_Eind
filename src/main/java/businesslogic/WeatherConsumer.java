package businesslogic;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WeatherConsumer {
    private static String url = "api.openweathermap.org/data/2.5/weather?";
    private static String key = "45f11f8c4e48c92c287cc43cf2fe8f7e";
    public final static String DEFAULT_SERVER
            = "http://www.elharo.com/fibonacci/SOAP";
    public final static String SOAP_ACTION
            = "http://www.example.com/fibonacci";


    public String aquireWeather(String lat, String lon) {
        String server = DEFAULT_SERVER;

        try {
            URL u = new URL(server);
            URLConnection uc = u.openConnection();
            HttpURLConnection connection = (HttpURLConnection) uc;

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("SOAPAction", SOAP_ACTION);

            OutputStream out = connection.getOutputStream();
            Writer wout = new OutputStreamWriter(out);

            wout.write("<?xml version='1.0'?>\r\n");
            wout.write("<SOAP-ENV:Envelope ");
            wout.write("xmlns:SOAP-ENV=");
            wout.write(
                    "'http://schemas.xmlsoap.org/soap/envelope/' "
            );
            wout.write("xmlns:xsi=");
            wout.write(
                    "'http://www.w3.org/2001/XMLSchema-instance'>\r\n");
            wout.write("  <SOAP-ENV:Body>\r\n");
            wout.write("    <calculateFibonacci ");
            wout.write(
                    "xmlns='http://namespaces.cafeconleche.org/xmljava/ch3/'\r\n"
            );
            wout.write("    type='xsi:positiveInteger'>" + input
                    + "</calculateFibonacci>\r\n");
            wout.write("  </SOAP-ENV:Body>\r\n");
            wout.write("</SOAP-ENV:Envelope>\r\n");

            wout.flush();
            wout.close();

            InputStream in = connection.getInputStream();
            int c;
            while ((c = in.read()) != -1) System.out.write(c);
            in.close();

        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}