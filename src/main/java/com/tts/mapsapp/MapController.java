package com.tts.mapsapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

	@GetMapping(path="/") 
	public String getDefaultMap() {
		return "index.html";
	}
}
