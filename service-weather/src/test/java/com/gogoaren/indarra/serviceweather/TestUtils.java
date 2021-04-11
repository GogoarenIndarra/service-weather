package com.gogoaren.indarra.serviceweather;

import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class TestUtils {

    public static WeatherEntity creatWeatherEntity(final String cityName, BigDecimal temperature) {
        return WeatherEntity.builder()
                .uuid(UUID.randomUUID())
                .created(Instant.now())
                .city(cityName)
                .humidity(0.0)
                .temperature(temperature)
                .wind(0.0)
                .build();
    }


}
