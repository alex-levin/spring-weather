package us.spring.weather.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherLocation {
	/**
	 * CWA - County Warning Area
	 * http://w1.weather.gov/glossary/index.php?letter=c
	 * i.e. BOX - Boston
	 * https://en.wikipedia.org/wiki/List_of_National_Weather_Service_Weather_Forecast_Offices
	 */
	private final String cwa;
	private final String gridX;
	private final String gridY;
	private final String radarStation;
	private final String timeZone;
	
	public static final String ROOT_URL = "https://api.weather.gov";
	// "https://api.weather.gov/offices/BOX"
	private final String forecastOffice;
	// "https://api.weather.gov/gridpoints/BOX/60,71"
	private final String forecastGridData;
	// "https://api.weather.gov/gridpoints/BOX/60,71/forecast"
	private final String forecastUrl;
	// "https://api.weather.gov/gridpoints/BOX/60,71/forecast/hourly"
	private final String forecastHourly;
	// "https://api.weather.gov/gridpoints/BOX/60,71/stations"
	private final String observationStations;

	@JsonCreator
	public WeatherLocation(@JsonProperty("cwa") String cwa,
			@JsonProperty("gridX") String gridX,
			@JsonProperty("gridY") String gridY,
			@JsonProperty("radarStation") String radarStation,
			@JsonProperty("timeZone") String timeZone) {
		this.cwa = cwa;
		this.gridX = gridX;
		this.gridY = gridY;
		this.radarStation = radarStation;
		this.timeZone = timeZone;
		
		forecastOffice = ROOT_URL + "/offices/" + cwa;
		forecastGridData = ROOT_URL + "/gridpoints/" + this.cwa + "/" + this.gridX + "," + this.gridY;
		forecastUrl = forecastGridData + "/forecast";
		forecastHourly = forecastUrl + "/hourly/";
		observationStations = forecastGridData + "/stations";
	}

	public String getRadarStation() {
		return radarStation;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public String getForecastOffice() {
		return forecastOffice;
	}

	public String getForecastGridData() {
		return forecastGridData;
	}

	public String getForecastUrl() {
		return forecastUrl;
	}

	public String getForecastHourly() {
		return forecastHourly;
	}

	public String getObservationStations() {
		return observationStations;
	}


}
