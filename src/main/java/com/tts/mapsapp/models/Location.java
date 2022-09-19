package com.tts.mapsapp.models;

import lombok.Data;

//In this project, Location is used in a
//multipurpose way, it is a bit of a hack...

//Because location stores latitude and longitude
//in a way that can be received via that 
//getForObject call...but the project also
//uses Location to store City and State from
//the form......
@Data
public class Location {
	private String city; // Does not participate in RestTemplate.getForObject	        
	private String state; // Does not participate in RestTemplate.getForObject
	private String lat;
	private String lng;
}
