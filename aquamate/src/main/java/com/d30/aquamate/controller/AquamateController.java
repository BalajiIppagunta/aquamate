package com.d30.aquamate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.d30.aquamate.business.AquamateServiceClass;
import com.d30.aquamate.dao.Activity;
import com.d30.aquamate.dao.PlanActivityRequest;
import com.d30.aquamate.dao.PlanActivityResponse;
import com.d30.aquamate.dao.User;
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
		return asc.consumeWeatherAPI(lat, lon);
	}

	@CrossOrigin
	@RequestMapping(value = "/PlanActivity/", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Get weather data for activity", response = PlanActivityResponse.class)
	public PlanActivityResponse planActivityAPI(@RequestBody PlanActivityRequest planActivityRequest) {
		logger.info("planActivityAPI function called");
		return asc.planActivityService(planActivityRequest);
	}

	@CrossOrigin
	@RequestMapping(value = "/adduser/", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Add a new User to the database", response = String.class)
	public String addUserAPI(@RequestBody User userrequest) {
		logger.info("addUser function called");
		return asc.addUser(userrequest);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/checkUserID/", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Check if user ID is available", response = User.class)
	public User checkUserID(@RequestParam String userid) {
		logger.info("checkUserID function called");
		return asc.checkUserID(userid);
	}
	@CrossOrigin
	@RequestMapping(value = "/authenticate/", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "User Authentication", response = Boolean.class)
	public Boolean authenticateUser(@RequestBody User userrequest) {
		logger.info("User Authentication initiated");
		return asc.authenticateUser(userrequest);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/saveActivity/", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Save the planned Activity to Database", response = String.class)
	public String saveActivity(@RequestBody PlanActivityRequest planActivityRequest) {
		logger.info("Request recieved to save the activity");
		return asc.savePlanActivity(planActivityRequest);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getSavedActivityByActivityandUserId/", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get the planned activity eith activity id and user id", response = Activity.class)
	public Activity getPlanActivityByActivityIdandUserId(@RequestParam String activityid,@RequestParam String userid) {
		logger.info("Fetching Activity with Activity and user ID");
		return asc.getPlanActivityByActivityIdandUserId(activityid,userid);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getSavedActivitiseByUserId/", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get all planned activities With user id", response = Activity.class)
	public List<Activity> getActivitiesByUserId(@RequestParam String userid) {
		logger.info("Fetching Activity with user ID");
		return asc.getPlanActivityByUserId(userid);
	}

}
