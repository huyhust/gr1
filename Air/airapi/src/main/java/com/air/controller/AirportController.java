package com.air.controller;

import com.air.service.AirportService;
import com.air.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airports")
@CrossOrigin(origins = "*")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping
    public ResponseEntity<String> getAirports(@RequestParam(defaultValue = "15") int limit, @RequestParam(defaultValue = "0") int offset) {
        String flightData = airportService.getAirportData(limit, offset);
        return new ResponseEntity<>(flightData, HttpStatus.OK);
    }
}
