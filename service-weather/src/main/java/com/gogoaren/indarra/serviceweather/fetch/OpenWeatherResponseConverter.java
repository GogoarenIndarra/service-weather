package com.gogoaren.indarra.serviceweather.fetch;

import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;


public class OpenWeatherResponseConverter {

    public WeatherEntity convert(OpenWeatherResponse openWeatherResponse) {
        return WeatherEntity.builder().city(openWeatherResponse.getName()).
                temp(convertTemperature(openWeatherResponse.getMain().getTemp()))
                .build();
    }

    private float convertTemperature(float kelvineTemp) {
        return kelvineTemp - 270;

    }

}
