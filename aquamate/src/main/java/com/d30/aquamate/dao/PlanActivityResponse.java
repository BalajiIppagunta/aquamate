package com.d30.aquamate.dao;

import org.springframework.stereotype.Component;

@Component
public class PlanActivityResponse {
	
	private String location;
	private String type;
	private String date;
	private String time;
	private String lat;
	private String lng;
	private String id;
	private Daily weaterResponse;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Daily getWeaterResponse() {
		return weaterResponse;
	}
	public void setWeaterResponse(Daily weaterResponse) {
		this.weaterResponse = weaterResponse;
	}
	
	

}
