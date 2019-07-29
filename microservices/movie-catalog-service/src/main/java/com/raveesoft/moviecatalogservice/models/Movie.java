package com.raveesoft.moviecatalogservice.models;

public class Movie {
	
	private String name;
	private String desc;
	
	
	
	public Movie() {
		super();
	}

	public Movie(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
