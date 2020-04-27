package com.d30.aquamate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.d30.aquamate.business.AquamateServiceClass;
import com.d30.aquamate.dao.PlanActivityRequest;
import com.d30.aquamate.dao.PlanActivityResponse;
import com.d30.aquamate.dao.WeatherResponse;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AquamateController {
	
	Logger logger = LoggerFactory.getLogger(AquamateController.class);
	
	@Value("${weather.api.key}")
	public String var; 
	
	@Autowired
	public AquamateServiceClass asc;
	
	
	@CrossOrigin
	@RequestMapping(value = "/WeatherAPI/", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get weather forecast and current weather", response = WeatherResponse.class)
	public WeatherResponse consumeWeatherAPI(@RequestParam(value = "lat", defaultValue = "60.99") String lat,
			@RequestParam(value = "lon", defaultValue = "30.9") String lon) {
		
		logger.info("consumeWeatherAPI function called");
		return asc.consumeWeatherAPI(lat,lon);
	}
	@CrossOrigin
	@RequestMapping(value = "/PlanActivity/", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Get weather data for activity", response = WeatherResponse.class)
	public PlanActivityResponse planActivityAPI(@RequestBody PlanActivityRequest planActivityRequest) {
		logger.info("planActivityAPI function called");
		return asc.planActivityService(planActivityRequest);
	}

}
