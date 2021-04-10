package com.gogoaren.indarra.serviceweather.controllers;


import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntityService;
import com.gogoaren.indarra.serviceweather.fetch.Weather;
import com.gogoaren.indarra.serviceweather.fetch.WeatherService;
import com.gogoaren.indarra.serviceweather.fetch.WeatherStatisticService;
import com.gogoaren.indarra.serviceweather.utils.CastomStringConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/api/weather")
@RestController
@AllArgsConstructor
@Slf4j
public class WeatherController {

    WeatherService weatherService;
    WeatherStatisticService weatherStatisticService;
    WeatherEntityService weatherEntityService;

    @GetMapping(value = "/{city}")
    public Weather getWeatherByCity(@PathVariable String city) {
        return weatherService.getWeatherByCity(CastomStringConverter.stringConvertforCity(city));
    }

    @GetMapping(value = "/topTen")
    public Map<String, BigDecimal> findTopTenWarmestCity(){
        return weatherStatisticService.findTopTenWarmestCity();
    }

    @GetMapping(value = "/topCity")
    public Map<String, BigDecimal> findWarmestCity() {
        return weatherStatisticService.findWarmestCity();
    }

    @PostMapping(value =  "/saveCity")
    public void saveEntity(@RequestBody Weather weather) {
        weatherEntityService.saveEntity(new WeatherEntity(weather));
    }

    @GetMapping(value = "/statistic")
    public void getStatistic() {
        return ;
    }


}



