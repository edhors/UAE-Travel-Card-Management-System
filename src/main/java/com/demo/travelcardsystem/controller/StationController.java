package com.demo.travelcardsystem.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/stations")
public class StationController {

    private static final String STATION_KEY = "station";
    private static final String ZONES_KEY = "zones";

    @GetMapping("/zones")
    public List<Map<String, Object>> getStationsWithZones() {
    	List<Map<String, Object>> stationList = new ArrayList<>();

    	Map<String, Object> s1 = new HashMap<>();
    	s1.put(STATION_KEY, "Algubaiba");
    	s1.put(ZONES_KEY, Arrays.asList(1));

    	Map<String, Object> s2 = new HashMap<>();
    	s2.put(STATION_KEY, "Jumeirah");
    	s2.put(ZONES_KEY, Arrays.asList(1, 2));

    	Map<String, Object> s3 = new HashMap<>();
    	s3.put(STATION_KEY, "Bur Dubai");
    	s3.put(ZONES_KEY, Arrays.asList(3));

    	Map<String, Object> s4 = new HashMap<>();
    	s4.put(STATION_KEY, "Deirah");
    	s4.put(ZONES_KEY, Arrays.asList(2));

    	stationList.add(s1);
    	stationList.add(s2);
    	stationList.add(s3);
    	stationList.add(s4);

    	return stationList;

    }
}
