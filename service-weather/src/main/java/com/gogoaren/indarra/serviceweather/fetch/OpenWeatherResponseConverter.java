package com.gogoaren.indarra.serviceweather.fetch;

import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OpenWeatherResponseConverter {

    public WeatherEntity converter(OpenWeatherResponse openWeatherResponse) {
        return WeatherEntity.builder().city(openWeatherResponse.getName()).
                temp(converterTemperature(openWeatherResponse.getMain().getTemp()))
                .build();
    }

    private float converterTemperature(float kelvineTemp) {
        return kelvineTemp - 270;

    }

}
