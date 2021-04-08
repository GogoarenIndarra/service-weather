package com.gogoaren.indarra.serviceweather.controllers;

import com.gogoaren.indarra.serviceweather.fetch.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Component
@Slf4j
public class Scheduler {

    @Autowired
    WeatherService weatherService;
//    Stream<String> cityNames = Stream.of("London", "Warsaw", "Berlin", "Madrid");
//
//    String randomElement = cityNamesB.get(rand.nextInt(cityNamesB.size()));

    @Scheduled(fixedDelayString = "${weather.schedule.update.ms}")
    public void getWeatherScheduleTask() {

        List<String> cityNamesB = Arrays.asList("London", "Warsaw", "Berlin",
                "Alicante", "Albuquerque", "Moscow", "Jijona", "Novomoskovsk", "Gebze", "Briançon");
        Random rand = new Random();
        String randomElement = cityNamesB.get(rand.nextInt(cityNamesB.size()));
        var weather = weatherService.getWeatherByCity(randomElement);
        log.info("Weather for " + randomElement + " at time: " + Instant.now() + " weather:  " + weather);
    }
}

/*
* "Albuquerque"
* */
