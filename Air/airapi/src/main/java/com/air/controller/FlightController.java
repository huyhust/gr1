package com.air.controller;

import com.air.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "*")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public ResponseEntity<String> getFlights(@RequestParam(defaultValue = "15") int limit, @RequestParam(defaultValue = "0") int offset) {
        String flightData = flightService.getFlightData(limit, offset);
        return new ResponseEntity<>(flightData, HttpStatus.OK);
    }
}