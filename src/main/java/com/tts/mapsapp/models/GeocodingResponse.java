package com.tts.mapsapp.models;

import java.util.List;

import lombok.Data;

//This class is going to hold the JSON result
//that we get from a GEOCODING query.

//It is set by RestTemplate.getForObject().....which
//read the JSON from the remote site, and maps it to
//fields inside this object.
@Data
public class GeocodingResponse {
	private List<Geocoding> results;
	String status;
}
