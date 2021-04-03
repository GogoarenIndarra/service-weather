package com.gogoaren.indarra.serviceweather.fetch;

import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;

import java.time.Instant;


public class OpenWeatherResponseConverter {

    public WeatherEntity convert(OpenWeatherResponse openWeatherResponse) {
        return WeatherEntity.builder().city(openWeatherResponse.getName()).
                temperature(convertTemperature(openWeatherResponse.getMain().getTemp()))
                .created(Instant.now())
                .build();
    }

    private float convertTemperature(float kelvineTemp) {
        return kelvineTemp - 270;

    }

}
