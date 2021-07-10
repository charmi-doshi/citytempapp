package com.bean;

import java.sql.Array;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("citytemp")
public class CityTempBean {

	//@Value("100")
	private Array cityTemp;
	
	//@Value("ahmedabad")
	private String city;
	
	//@Value("morning,evening,night")
	private String phase;
	
	public Array getCityTemp() {
		return cityTemp;
	}
	public void setCityTemp(Array cityTemp) {
		this.cityTemp = cityTemp;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	
	
	
	
}
