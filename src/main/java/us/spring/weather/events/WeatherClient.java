package us.spring.weather.events;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {
	public final String ROOT_URL = "https://api.weather.gov/points/";
	private final RestTemplate restTemplate;
	
	public WeatherClient(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	public WeatherLocation getWeatherLocation(String lat, String lon) {
		WeatherRoot weatherRoot
		  = restTemplate.getForObject(String.format(ROOT_URL + "%s,%s", lat, lon), WeatherRoot.class);
		return weatherRoot.getLocation();
	}
}


