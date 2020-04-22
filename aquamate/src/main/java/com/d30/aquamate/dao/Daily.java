package com.d30.aquamate.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Daily {
	
	public String dt; // Time of the forecasted data, unix, UTC
	public String sunrise; // Sunrise time, unix, UTC
	public String sunset; // Sunset time, unix, UTC
	public Temp temp;
	public FeelsLike feels_like;
	public String pressure; // Atmospheric pressure on the sea level, hPa
	public String humidity; // Humidity, %
	public String dew_point; // Atmospheric temperature (varying according to pressure and humidity) below which water droplets begin to condense and dew can form. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	public String wind_speed; // Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour. How to change units format
	public String wind_gust; // Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour. How to change units format
	public String wind_deg; // Wind direction, degrees (meteorological)
	public String clouds; // Cloudiness, %
	public String uvi; // UV index
	public String visibility; // Average visibility, meters
	public String rain; // Precipitation volume, mm
	public String snow; // Snow volume, mm
	public List<Weather> weather; // (more info Weather condition codes)


}
