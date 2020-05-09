package com.d30.aquamate.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Activity {

	@Id
	private String activityid;
	private String location;
	private String type;
	private String date;
	private String time;
	private String lat;
	private String lng;
	private String userid;

	/**
	 * @return the activityid
	 */
	public String getActivityid() {
		return activityid;
	}

	/**
	 * @param activityid
	 *            the activityid to set
	 */
	public void setActivityid(String activityid) {
		this.activityid = activityid;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat
	 *            the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * @param lng
	 *            the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * @return the user
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Activitydao [activityid=" + activityid + ", location=" + location + ", type=" + type + ", date=" + date
				+ ", time=" + time + ", lat=" + lat + ", lng=" + lng + "]";
	}

}
