package org.example.service;

import org.example.dto.Weather;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WeatherService {

    private final Random rnd = new Random();
    public Weather getWeather(String town){
        return (new Weather(rnd.nextDouble(-50.0, 45.0),
                            rnd.nextInt(0,100),
                            rnd.nextInt(740, 780)));
    }
}
