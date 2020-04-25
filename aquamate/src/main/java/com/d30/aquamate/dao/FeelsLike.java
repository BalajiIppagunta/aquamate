package com.d30.aquamate.dao;

import org.springframework.stereotype.Component;

@Component
public class FeelsLike {

	private String morn; // Morning temperature.Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit. How to change units format
	private String day; // Day temperature.Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	private String eve; // Evening temperature.Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	private String night; // Night temperature.Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	public String getMorn() {
		return morn;
	}
	public void setMorn(String morn) {
		this.morn = morn;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getEve() {
		return eve;
	}
	public void setEve(String eve) {
		this.eve = eve;
	}
	public String getNight() {
		return night;
	}
	public void setNight(String night) {
		this.night = night;
	}
	
	@Override
	public String toString() {
		return "FeelsLike [" + (morn != null ? "morn=" + morn + ", " : "") + (day != null ? "day=" + day + ", " : "")
				+ (eve != null ? "eve=" + eve + ", " : "") + (night != null ? "night=" + night : "") + "]";
	}
	
	
	
	
}
