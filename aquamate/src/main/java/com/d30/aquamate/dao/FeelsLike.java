package com.d30.aquamate.dao;

import org.springframework.stereotype.Component;

@Component
public class FeelsLike {

	public String morn; // Morning temperature.Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit. How to change units format
	public String day; // Day temperature.Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	public String eve; // Evening temperature.Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	public String night; // Night temperature.Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
	
}
