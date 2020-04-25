package com.d30.aquamate.dao;

import org.springframework.stereotype.Component;

@Component
public class Temp {
	
	private String morn; // Morning temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit. How to change units format
	private String day; // Day temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	private String eve; // Evening temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	private String night; // Night temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	private String min; // Min daily temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	private String max; // Max daily temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	/**
	 * @return the morn
	 */
	public String getMorn() {
		return morn;
	}
	/**
	 * @param morn the morn to set
	 */
	public void setMorn(String morn) {
		this.morn = morn;
	}
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the eve
	 */
	public String getEve() {
		return eve;
	}
	/**
	 * @param eve the eve to set
	 */
	public void setEve(String eve) {
		this.eve = eve;
	}
	/**
	 * @return the night
	 */
	public String getNight() {
		return night;
	}
	/**
	 * @param night the night to set
	 */
	public void setNight(String night) {
		this.night = night;
	}
	/**
	 * @return the min
	 */
	public String getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(String min) {
		this.min = min;
	}
	/**
	 * @return the max
	 */
	public String getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(String max) {
		this.max = max;
	}
	
	@Override
	public String toString() {
		return "Temp [" + (morn != null ? "morn=" + morn + ", " : "") + (day != null ? "day=" + day + ", " : "")
				+ (eve != null ? "eve=" + eve + ", " : "") + (night != null ? "night=" + night + ", " : "")
				+ (min != null ? "min=" + min + ", " : "") + (max != null ? "max=" + max : "") + "]";
	}
	
	
	
	

}