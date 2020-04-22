package com.d30.aquamate.dao;

import org.springframework.stereotype.Component;

@Component
public class Temp {
	
	public String morn; // Morning temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit. How to change units format
	public String day; // Day temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	public String eve; // Evening temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	public String night; // Night temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	public String min; // Min daily temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	public String max; // Max daily temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	

}