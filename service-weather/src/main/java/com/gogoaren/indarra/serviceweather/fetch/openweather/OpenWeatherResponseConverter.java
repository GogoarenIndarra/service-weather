package com.gogoaren.indarra.serviceweather.fetch.openweather;

import com.gogoaren.indarra.serviceweather.fetch.Weather;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OpenWeatherResponseConverter {

    public Weather convert(OpenWeatherResponse openWeatherResponse) {
        return Weather.builder()
                .city(openWeatherResponse.getName())
                .temperature(convertTemperature(openWeatherResponse.getMain().getTemp()))
                .humidity(openWeatherResponse.getMain().getHumidity())
                .wind(openWeatherResponse.getWind().getSpeed())
                .country(openWeatherResponse.getSys().getCountry())
                .build();
    }

    private BigDecimal convertTemperature(double kelvineTemp) {

        BigDecimal a = new BigDecimal(kelvineTemp);
        BigDecimal b = new BigDecimal(273.15);
        return a.subtract(b).setScale(2, RoundingMode.CEILING);
    }

}
