package com.d30.aquamate.dao;

import org.springframework.stereotype.Component;

@Component
public class Weather {
	
	private String id;// Weather condition id
	private String main; // Group of weather parameters (Rain, Snow, Extreme etc.)
	private String description; // Weather condition within the group (full list of weather conditions). Get the output in your language
	private String icon; // Weather icon id. How to get icons
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the main
	 */
	public String getMain() {
		return main;
	}
	/**
	 * @param main the main to set
	 */
	public void setMain(String main) {
		this.main = main;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + "]";
	}
	
	

}
