package com.tts.mapsapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tts.mapsapp.models.GeocodingResponse;
import com.tts.mapsapp.models.Location;

//WE want to be able to autowire to create a MapService
//WE don't want to have to create a MapService using a 
// new MapService() statement...... we want SpringBoot to be able
//to make one magically. And to this end we have to tell SpringBoot
//that it is okay to do so.

@Service //This annotation doesn't do much except tell the programmers
         //and springboot that this is meant to be a service.  One of the few
         //things that this will cause SpringBoot to do is it will add our
         //MapService to it automatic object management, so we can Autowire it in.

		 //(This will make the MapService into a Bean so it is managed by SpringBoot's
         // Inversion of Control system)
public class MapService {
	
	@Value("${api_key}")	
	private String apiKey;
	
	
	//I want to add a method to do an API call.
	//This is going to take a Location object which will contain
	//the search information (City,State)...and will add to that location
	//the latitude and longitude returned by the Google GEOCODING API.
	public void addCoordinates(Location location) {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
			location.getCity() + "," + location.getState() + "&key=" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = 
			restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		location.setLat(coordinates.getLat());
		location.setLng(coordinates.getLng());			
	}
}
