package com.java.restassured.starwarsapi;

public class Person {
	
	private String name;
	private String gender;
	private String[] films;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getFilms() {
		return films;
	}
	public void setFilms(String[] films) {
		this.films = films;
	}
	

}
