package com.suru.springboot.bootrest.domain;

public class Weather {
	private String temprature;
	private String description;
	private Location location;

	public Weather() {
	}

	public Weather(String temprature, String description, Location location) {
		this.temprature = temprature;
		this.description = description;
		this.location = location;
	}

	public String getTemprature() {
		return temprature;
	}

	public void setTemprature(String temprature) {
		this.temprature = temprature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Weather [temprature=" + temprature + ", description=" + description + ", location=" + location + "]";
	}

}
