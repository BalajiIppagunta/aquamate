package com.d30.aquamate.business;


import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.d30.aquamate.dao.CurrentWeather;
import com.d30.aquamate.dao.Daily;
import com.d30.aquamate.dao.PlanActivityRequest;
import com.d30.aquamate.dao.PlanActivityResponse;
import com.d30.aquamate.dao.WeatherResponse;

@Service

public class AquamateServiceClass {

	@Value("${weather.api.url}")
	public String weatherAPIUrl;
	@Value("${weather.api.key}")
	public String weatherAPIKey;

	public String unixDatetoNormalDate(String unixdate) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return sdf.format(new Date((Long.parseLong(unixdate)) * 1000)).toString();
	}
	public String unixDatetotime(String unixdate) {

		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		return sdf.format(new Date((Long.parseLong(unixdate)) * 1000)).toString();
	}
		
	

	public WeatherResponse consumeWeatherAPI(String lat, String lon) {

		System.out.println("Processing Request");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(weatherAPIUrl + "lat=" + lat + "&lon=" + lon +"&units=metric"+ "&appid=" + weatherAPIKey);
		try {
			ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(
					weatherAPIUrl + "lat=" + lat + "&lon=" + lon +"&units=metric"+ "&appid=" + weatherAPIKey, WeatherResponse.class);
			System.out.println("Got response");
			System.out.println(response.getBody());

			WeatherResponse responsebody = response.getBody();
			responsebody.getCurrent().setDt((unixDatetoNormalDate(responsebody.getCurrent().getDt())));
			responsebody.getCurrent().setSunrise((unixDatetotime(responsebody.getCurrent().getSunrise())));
			responsebody.getCurrent().setSunset((unixDatetotime(responsebody.getCurrent().getSunset())));
			responsebody.getDaily().forEach(foo -> foo.setDt((unixDatetoNormalDate(foo.getDt()))));
			responsebody.getDaily().forEach(foo -> foo.setSunrise((unixDatetotime(foo.getSunrise()))));
			responsebody.getDaily().forEach(foo -> foo.setSunset((unixDatetotime(foo.getSunset()))));

			return responsebody;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public PlanActivityResponse planActivityService(PlanActivityRequest planActivityRequest) {

		PlanActivityResponse response = new PlanActivityResponse();
		response.setDate(planActivityRequest.getDate());
		response.setLat(planActivityRequest.getLat());
		response.setLng(planActivityRequest.getLng());
		response.setLocation(planActivityRequest.getLocation());
		response.setTime(planActivityRequest.getTime());
		response.setType(planActivityRequest.getType());
		
		
		WeatherResponse weatherResponse = consumeWeatherAPI(planActivityRequest.getLat(), planActivityRequest.getLng());
		List<Daily> daily = new ArrayList<Daily>();
		CurrentWeather current = new CurrentWeather();
		if(weatherResponse==null) {
			
			System.out.println("WeatherAPI NO RESPONSE");
			response.setWeaterResponse(null);
			return response;
		}
		else if (weatherResponse.getCurrent().getDt().equalsIgnoreCase(planActivityRequest.getDate())) {

			current= weatherResponse.getCurrent();
			response.setWeaterResponse(current);
			return response;
		}
		else{
			daily=weatherResponse.getDaily().stream().filter(foo -> foo.getDt().equalsIgnoreCase(planActivityRequest.getDate())).collect(Collectors.toList());
			//weather=weatherStream;
			current.setClouds(daily.get(0).getClouds());
			current.setDew_point(daily.get(0).getDew_point());
			current.setFeels_like(daily.get(0).getFeels_like().toString());
			current.setDt(daily.get(0).getDt());
			current.setHumidity(daily.get(0).getHumidity());
			current.setPressure(daily.get(0).getPressure());
			current.setRain(daily.get(0).getRain());
			current.setSnow(daily.get(0).getSnow());
			current.setSunrise(daily.get(0).getSunrise());
			current.setSunset(daily.get(0).getSunset());
			current.setTemp(daily.get(0).getTemp().toString());
			current.setUvi(daily.get(0).getUvi());
			current.setVisibility(daily.get(0).getVisibility());
			current.setWeather(daily.get(0).getWeather());
			current.setWind_deg(daily.get(0).getWind_deg());
			current.setWind_gust(daily.get(0).getWind_gust());
			current.setWind_speed(daily.get(0).getWind_speed());
			response.setWeaterResponse(current);
			return response;
			
		}

		
		
	}

}
