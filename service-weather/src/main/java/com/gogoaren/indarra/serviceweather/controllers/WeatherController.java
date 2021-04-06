package com.gogoaren.indarra.serviceweather.controllers;


import com.gogoaren.indarra.serviceweather.fetch.Weather;
import com.gogoaren.indarra.serviceweather.fetch.WeatherService;
import com.gogoaren.indarra.serviceweather.fetch.WeatherStatisticService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/api/weather")
@RestController
@AllArgsConstructor
@Slf4j
public class WeatherController {

    WeatherService weatherService;
    WeatherStatisticService weatherStatisticService;

    @GetMapping(value = "/{city}")
    public Weather getWeatherByCity(@PathVariable String city) {
        return weatherService.getWeatherByCity(city);
    }

    @GetMapping(value = "/topTen")
    public Map<String, BigDecimal> findTopTenWarmestCity(){
        return weatherStatisticService.findTopTenWarmestCity();
    }

    @GetMapping(value = "/topCity")
    public Map<String, BigDecimal> findWarmestCity() {
        return weatherStatisticService.findWarmestCity();
    }
}



