package com.d30.aquamate.dao;

import org.springframework.stereotype.Component;

@Component
public class Weather {
	
	public String id;// Weather condition id
	public String main; // Group of weather parameters (Rain, Snow, Extreme etc.)
	public String description; // Weather condition within the group (full list of weather conditions). Get the output in your language
	public String icon; // Weather icon id. How to get icons

}
