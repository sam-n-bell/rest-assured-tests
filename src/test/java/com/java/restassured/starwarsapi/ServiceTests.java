package com.java.restassured.starwarsapi;

import org.junit.BeforeClass;
import org.junit.Test;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class ServiceTests  
{
	
	Gson gson = new Gson();
	Person person = new Person();
	
	@BeforeClass
	public static void setup()
	{
		RestAssured.baseURI = "https://swapi.co/api/";
	}
	
	@Test
	public void assertPeopleOneIsLukeSkywalker()
	{
		Response response = RestAssured.given().when().get("people/1/");
		person = gson.fromJson(response.asString(), Person.class);
		assertThat(person.getName(), equalToIgnoringCase("Luke Skywalker"));
	}
	
	@Test
	public void assertPeopleOneIsInSixFilms()
	{
		Response response = RestAssured.given().when().get("people/1/");
		person = gson.fromJson(response.asString(), Person.class);
		assertThat(person.getFilms().length, is(5));
	}
	
	@Test
	public void assertThatInvalidPersonReturnsNotFoundMessage()
	{
		Response response = RestAssured.given().when().get("people/r/");
		assertThat(response.body().jsonPath().getString("detail"), equalToIgnoringCase("Not Found"));
	}

}
