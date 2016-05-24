package businesslogic;
public class WeatherConsumer {

    public static businesslogic.net.webservicex.WeatherForecasts getWeatherByZipCode(java.lang.String zipCode) {
        businesslogic.net.webservicex.WeatherForecast service = new businesslogic.net.webservicex.WeatherForecast();
        businesslogic.net.webservicex.WeatherForecastSoap port = service.getWeatherForecastSoap();
        return port.getWeatherByZipCode(zipCode);

    }
}