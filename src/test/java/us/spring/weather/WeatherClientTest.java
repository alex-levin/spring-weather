package us.spring.weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import us.spring.weather.events.WeatherClient;
import us.spring.weather.events.WeatherLocation;

public class WeatherClientTest {
	@Test
	public void test() {
		// https://api.weather.gov/points/42.29,-71.39
		RestTemplateBuilder builder = new RestTemplateBuilder();
		WeatherClient client = new WeatherClient(builder);
		WeatherLocation location = client.getWeatherLocation("42.29", "-71.39");
		
		assertEquals(location.getRadarStation(), "KBOX");
		assertEquals(location.getTimeZone(), "America/New_York");
		assertEquals(location.getForecastOffice(), "https://api.weather.gov/offices/BOX");
		assertEquals(location.getForecastUrl(), "https://api.weather.gov/gridpoints/BOX/60,71/forecast");
		assertEquals(location.getForecastHourly(), "https://api.weather.gov/gridpoints/BOX/60,71/forecast/hourly");
		assertEquals(location.getForecastGridData(), "https://api.weather.gov/gridpoints/BOX/60,71");
		assertEquals(location.getObservationStations(), "https://api.weather.gov/gridpoints/BOX/60,71/stations");
	}
}
