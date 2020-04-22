package com.d30.aquamate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.d30.aquamate.business.AquamateServiceClass;
import com.d30.aquamate.dao.PlanActivityRequest;
import com.d30.aquamate.dao.PlanActivityResponse;
import com.d30.aquamate.dao.WeatherResponse;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AquamateController {
	
	@Value("${weather.api.key}")
	public String var; 
	
	@Autowired
	public AquamateServiceClass asc;
	
	
	
	@RequestMapping(value = "/WeatherAPI/", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get weather forecast and current weather", response = WeatherResponse.class)
	public WeatherResponse consumeWeatherAPI(@RequestParam(value = "lat", defaultValue = "60.99") String lat,
			@RequestParam(value = "lon", defaultValue = "30.9") String lon) {
		System.out.println("Service class called");
		return asc.consumeWeatherAPI(lat,lon);
	}
	
	@RequestMapping(value = "/PlanActivity/", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Get weather data for activity", response = WeatherResponse.class)
	public PlanActivityResponse planActivityAPI(@RequestBody PlanActivityRequest planActivityRequest) {
		System.out.println("Service class called");
		return asc.planActivityService(planActivityRequest);
	}

}
