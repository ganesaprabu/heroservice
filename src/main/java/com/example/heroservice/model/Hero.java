package com.example.heroservice.model;

import java.util.List;

public class Hero {

	private Integer id;
	private String name;
	private String power;
	private Appearance appearance;
	private List<String> weaknesses;
	private List<String> alliances;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public Appearance getAppearance() {
		return appearance;
	}
	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}
	public List<String> getWeaknesses() {
		return weaknesses;
	}
	public void setWeaknesses(List<String> weaknesses) {
		this.weaknesses = weaknesses;
	}
	public List<String> getAlliances() {
		return alliances;
	}
	public void setAlliances(List<String> alliances) {
		this.alliances = alliances;
	}
	
	
}
