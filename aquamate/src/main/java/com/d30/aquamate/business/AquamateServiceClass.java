package com.d30.aquamate.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.d30.aquamate.dao.PlanActivityRequest;
import com.d30.aquamate.dao.PlanActivityResponse;
import com.d30.aquamate.dao.WeatherResponse;

@Service

public class AquamateServiceClass {
	
	@Value("${weather.api.url}")
	public String weatherAPIUrl;
	@Value("${weather.api.key}")
	public String weatherAPIKey;



	public WeatherResponse consumeWeatherAPI(String lat, String lon) {

		System.out.println("Processing Request");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(weatherAPIUrl + "lat=" + lat + "&lon=" + lon + "&appid=" + weatherAPIKey);
		try {
			ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(
					weatherAPIUrl + "lat=" + lat + "&lon=" + lon + "&appid=" + weatherAPIKey, WeatherResponse.class);
			System.out.println("Got response");
			System.out.println(response.getBody());
			WeatherResponse responsebody = response.getBody();
			// responsebody.
			return responsebody;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public PlanActivityResponse planActivityService(PlanActivityRequest planActivityRequest) {

		WeatherResponse weatherResponse = consumeWeatherAPI(planActivityRequest.getLat(), planActivityRequest.getLng());
		PlanActivityResponse response= new PlanActivityResponse();
		response.setDate(planActivityRequest.getDate());
		response.setLat(planActivityRequest.getLat());
		response.setLng(planActivityRequest.getLng());
		response.setLocation(planActivityRequest.getLocation());
		response.setTime(planActivityRequest.getTime());
		response.setType(planActivityRequest.getType());
		response.setWeaterResponse(weatherResponse);
		return response;
	}

}
