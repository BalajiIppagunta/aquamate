package com.d30.aquamate.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WeatherResponse {

	
	private String lat; // Geographical coordinates of the location (latitude)
	private String lon; // Geographical coordinates of the location (longitude)
	private String timezone; // Timezone name for the requested location
	private CurrentWeather current;// //weather data API response
	private List<Hourly> hourly; // forecast weather data API response
	private List<Daily> daily; // forecast weather data API response
	
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public CurrentWeather getCurrent() {
		return current;
	}
	public void setCurrent(CurrentWeather current) {
		this.current = current;
	}
	public List<Hourly> getHourly() {
		return hourly;
	}
	public void setHourly(List<Hourly> hourly) {
		this.hourly = hourly;
	}
	public List<Daily> getDaily() {
		return daily;
	}
	public void setDaily(List<Daily> daily) {
		this.daily = daily;
	}
	
	
	
}
