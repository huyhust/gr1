package com.air.service.impl;

import com.air.service.AirportService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirportServiceImpl implements AirportService {
    private final String API_KEY = "31d4ba4ee1388f575fccf4bc81336b46";
    private final String API_URL = "http://api.aviationstack.com/v1/airports";

    @Override
    public String getAirportData(int limit, int offset) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "?access_key=" + API_KEY+"&limit="+limit+"&offset="+offset;
        return restTemplate.getForObject(url, String.class);
    }
}
