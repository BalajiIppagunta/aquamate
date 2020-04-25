package com.d30.aquamate.business;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.d30.aquamate.dao.CurrentWeather;
import com.d30.aquamate.dao.CurrentWeatherPlanActivity;
import com.d30.aquamate.dao.Daily;
import com.d30.aquamate.dao.FeelsLike;
import com.d30.aquamate.dao.Hourly;
import com.d30.aquamate.dao.PlanActivityRequest;
import com.d30.aquamate.dao.PlanActivityResponse;
import com.d30.aquamate.dao.Temp;
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
		System.out.println(weatherAPIUrl + "lat=" + lat + "&lon=" + lon + "&units=metric" + "&appid=" + weatherAPIKey);
		try {
			ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(
					weatherAPIUrl + "lat=" + lat + "&lon=" + lon + "&units=metric" + "&appid=" + weatherAPIKey,
					WeatherResponse.class);
			System.out.println("Got response");
			System.out.println(response.getBody());

			WeatherResponse responsebody = response.getBody();
			responsebody.getCurrent().setDt((unixDatetoNormalDate(responsebody.getCurrent().getDt())));
			responsebody.getCurrent().setSunrise((unixDatetotime(responsebody.getCurrent().getSunrise())));
			responsebody.getCurrent().setSunset((unixDatetotime(responsebody.getCurrent().getSunset())));
			responsebody.getDaily().forEach(foo -> foo.setDt((unixDatetoNormalDate(foo.getDt()))));
			responsebody.getDaily().forEach(foo -> foo.setSunrise((unixDatetotime(foo.getSunrise()))));
			responsebody.getDaily().forEach(foo -> foo.setSunset((unixDatetotime(foo.getSunset()))));
			responsebody.getHourly().forEach(foo -> foo.setDt((unixDatetotime(foo.getDt()))));

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

		Daily current = new Daily();
		if (weatherResponse == null) {

			System.out.println("WeatherAPI NO RESPONSE");
			response.setWeaterResponse(null);
			return response;
		} else if (weatherResponse.getCurrent().getDt().equalsIgnoreCase(planActivityRequest.getDate())) {

			CurrentWeather weatherInResponse = weatherResponse.getCurrent();

			Temp temp = new Temp();
			FeelsLike feels_like = new FeelsLike();

			if (weatherResponse.getHourly().size() <= 48 && weatherResponse.getHourly().size() >= 1) {

				List<Hourly> mrng = weatherResponse.getHourly().subList(0, 7);
				List<Hourly> day = weatherResponse.getHourly().subList(7, 13);
				List<Hourly> eve = weatherResponse.getHourly().subList(13, 19);
				List<Hourly> night = weatherResponse.getHourly().subList(19, 24);

				Double averageTemp = mrng.stream().mapToDouble(a -> Double.parseDouble(a.getTemp())).average()
						.orElse(0.00);
				temp.setMorn(averageTemp.toString());
				averageTemp = day.stream().mapToDouble(a -> Double.parseDouble(a.getTemp())).average().orElse(0.00);
				temp.setDay(averageTemp.toString());
				averageTemp = eve.stream().mapToDouble(a -> Double.parseDouble(a.getTemp())).average().orElse(0.00);
				temp.setEve(averageTemp.toString());
				averageTemp = night.stream().mapToDouble(a -> Double.parseDouble(a.getTemp())).average().orElse(0.00);
				temp.setNight(averageTemp.toString());

				Hourly maxTemp = weatherResponse.getHourly().subList(0, 25).stream()
						.max(Comparator.comparing(Hourly::getTemp)).orElseThrow(NoSuchElementException::new);
				Hourly minTemp = weatherResponse.getHourly().subList(0, 25).stream()
						.min(Comparator.comparing(Hourly::getTemp)).orElseThrow(NoSuchElementException::new);

				temp.setMax(maxTemp.getTemp());
				temp.setMin(minTemp.getTemp());

				Double averageFeelsLike = mrng.stream().mapToDouble(a -> Double.parseDouble(a.getFeels_like()))
						.average().orElse(0.00);
				feels_like.setMorn(averageFeelsLike.toString());
				averageFeelsLike = day.stream().mapToDouble(a -> Double.parseDouble(a.getFeels_like())).average()
						.orElse(0.00);
				feels_like.setDay(averageFeelsLike.toString());
				averageFeelsLike = eve.stream().mapToDouble(a -> Double.parseDouble(a.getFeels_like())).average()
						.orElse(0.00);
				feels_like.setEve(averageFeelsLike.toString());
				averageFeelsLike = night.stream().mapToDouble(a -> Double.parseDouble(a.getFeels_like())).average()
						.orElse(0.00);
				feels_like.setNight(averageFeelsLike.toString());

				System.out.println("4 parts");
				System.out.println(temp);
				System.out.println(feels_like);

			}

			current.setClouds(weatherInResponse.getClouds());
			current.setDew_point(weatherInResponse.getDew_point());
			current.setFeels_like(feels_like);
			current.setDt(weatherInResponse.getDt());
			current.setHumidity(weatherInResponse.getHumidity());
			current.setPressure(weatherInResponse.getPressure());
			// current.setRain(weatherInResponse.getRain());
			current.setSnow(weatherInResponse.getSnow());
			current.setSunrise(weatherInResponse.getSunrise());
			current.setSunset(weatherInResponse.getSunset());
			current.setTemp(temp);
			current.setUvi(weatherInResponse.getUvi());
			current.setVisibility(weatherInResponse.getVisibility());
			current.setWeather(weatherInResponse.getWeather());
			current.setWind_deg(weatherInResponse.getWind_deg());
			current.setWind_gust(weatherInResponse.getWind_gust());
			current.setWind_speed(weatherInResponse.getWind_speed());

			response.setWeaterResponse(current);
			return response;
		} else {
			List<Daily> daily = weatherResponse.getDaily().stream()
					.filter(foo -> foo.getDt().equalsIgnoreCase(planActivityRequest.getDate()))
					.collect(Collectors.toList());
			// current.
			response.setWeaterResponse(daily.get(0));
			return response;

		}

	}

}
