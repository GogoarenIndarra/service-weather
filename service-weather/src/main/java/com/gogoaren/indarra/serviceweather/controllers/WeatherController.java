package com.gogoaren.indarra.serviceweather.controllers;


import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntityService;
import com.gogoaren.indarra.serviceweather.fetch.OpenWeatherFetcher;
import com.gogoaren.indarra.serviceweather.fetch.OpenWeatherResponse;
import com.gogoaren.indarra.serviceweather.fetch.OpenWeatherResponseConverter;
import com.gogoaren.indarra.serviceweather.fetch.Weather;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/api/weather")
@RestController
@AllArgsConstructor
@Slf4j
public class WeatherController {

    private OpenWeatherFetcher openWeatherFetcher;
    private OpenWeatherResponseConverter converter;
    private WeatherEntityService weatherEntityService;

    @GetMapping(value = "/{city}")
    public Weather getWeatherByCity(@PathVariable String city) {

        Optional<WeatherEntity> optionalWeatherEntity =
                weatherEntityService.findLatestStoredTemperature(city);


        if (optionalWeatherEntity.isPresent()) {
            log.info("weather from db: " + optionalWeatherEntity);

            WeatherEntity weatherEntity = optionalWeatherEntity.get();
            return Weather.builder()
                    .humidity(weatherEntity.getHumidity())
                    .city(weatherEntity.getCity())
                    .temperature(weatherEntity.getTemperature())
                    .wind(weatherEntity.getWind())
                    .build();
        }


        log.info("fetching weather for: " + city);
        OpenWeatherResponse openWeatherResponse = openWeatherFetcher.fetchWeatherByCityName(city);
        log.info("open weather response: " + openWeatherResponse);
        Weather weather = converter.convert(openWeatherResponse);

        WeatherEntity weatherEntity = WeatherEntity.builder()
                .uuid(UUID.randomUUID())
                .created(Instant.now())
                .city(weather.getCity())
                .humidity(weather.getHumidity())
                .temperature(weather.getTemperature())
                .wind(weather.getWind())
                .build();
        log.info("save weather entity: " + weatherEntity.toString());
        weatherEntityService.saveEntity(weatherEntity);
        return weather;
    }

}
