package us.spring.weather.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherRoot {
	private final WeatherLocation location;
	
	public WeatherRoot(@JsonProperty("properties") WeatherLocation location) {
		this.location = location;
	}

	public WeatherLocation getLocation() {
		return location;
	}
	
	
}
