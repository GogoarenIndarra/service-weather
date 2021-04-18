package com.gogoaren.indarra.serviceweather.Scheduler;

import com.gogoaren.indarra.serviceweather.fetch.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class Scheduler {

    @Autowired
    WeatherService weatherService;

    @Scheduled(fixedDelayString = "${weather.schedule.update.ms}")
    public void uploadWeatherScheduleTask() {

        List<String> cityNamesB = Arrays.asList(
                "London", "Warsaw", "Berlin", "Alicante", "Albuquerque", "Moscow",
                "Jijona", "Novomoskovsk", "Gebze", "Briançon", "Oban", "Santiago de Cali",
                "Port Montt", "Cape Town");

        Random rand = new Random();
        String randomElement = cityNamesB.get(rand.nextInt(cityNamesB.size()));
        var weather = weatherService.getWeatherByCity(randomElement);
        log.info("Weather for " + randomElement + " at time: " + Instant.now() + " weather:  " + weather);
    }


    @Scheduled(cron = "${weather.schedule.cron.london.ms}")
    public void uploadLondonWeatherScheduleTask() {
        uploadWeather("London");
    }

    private void uploadWeather(String city) {
        var weather = weatherService.getWeatherByCity(city);
        log.info("Weather for " + city + " at time: " + Instant.now() + " weather:  " + weather);
    }
}
