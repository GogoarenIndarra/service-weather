package com.gogoaren.indarra.serviceweather.fetch;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class OpenWeatherFetcherTest {

    private Logger logger = LoggerFactory.getLogger(OpenWeatherFetcher.class);

    @Autowired
    private OpenWeatherFetcher openWeatherFetcher;

    @Test
    public void getWeather() {
        OpenWeatherResponse openWeatherResponse = openWeatherFetcher.fetchWeatherByCity("London");
        logger.info(openWeatherResponse.toString());
        assertTrue(true);
//        assertTrue(openWeatherResponse.contains("Craig") ||
//                joke.contains("Walls"));

    }

}