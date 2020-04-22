package com.d30.aquamate.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WeatherResponse {

	
	public String lat; // Geographical coordinates of the location (latitude)
	public String lon; // Geographical coordinates of the location (longitude)
	public String timezone; // Timezone name for the requested location
	public CurrentWeather current;// //weather data API response
	public List<Hourly> hourly; // forecast weather data API response
	public List<Daily> daily; // forecast weather data API response
	
}
