package com.d30.aquamate.dao;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class CurrentWeather {
	
	private String dt; // Current time, unix, UTC
	private String sunrise;// Sunrise time, unix, UTC
	private String sunset; // Sunset time, unix, UTC
	private String temp; // Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit. How to change units format
	private String feels_like; // Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	private String pressure; // Atmospheric pressure on the sea level, hPa
	private String humidity; // Humidity, %
	private String dew_point; // Atmospheric temperature (varying according to pressure and humidity) below which water droplets begin to condense and dew can form. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	private String clouds; // Cloudiness, %
	private String uvi; // UV index
	private String visibility; // Average visibility, meters
	private String wind_speed; // Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour. How to change units format
	private String wind_gust; // Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour. How to change units format
	private String wind_deg; // Wind direction, degrees (meteorological)
	private String rain; // Precipitation volume, mm
	private String snow; // Snow volume, mm
	private List<Weather> weather;//  (more info Weather condition codes)
	
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(String feels_like) {
		this.feels_like = feels_like;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getDew_point() {
		return dew_point;
	}
	public void setDew_point(String dew_point) {
		this.dew_point = dew_point;
	}
	public String getClouds() {
		return clouds;
	}
	public void setClouds(String clouds) {
		this.clouds = clouds;
	}
	public String getUvi() {
		return uvi;
	}
	public void setUvi(String uvi) {
		this.uvi = uvi;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(String wind_speed) {
		this.wind_speed = wind_speed;
	}
	public String getWind_gust() {
		return wind_gust;
	}
	public void setWind_gust(String wind_gust) {
		this.wind_gust = wind_gust;
	}
	public String getWind_deg() {
		return wind_deg;
	}
	public void setWind_deg(String wind_deg) {
		this.wind_deg = wind_deg;
	}
	public String getRain() {
		return rain;
	}
	public void setRain(String rain) {
		this.rain = rain;
	}
	public String getSnow() {
		return snow;
	}
	public void setSnow(String snow) {
		this.snow = snow;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	
	
	

}
