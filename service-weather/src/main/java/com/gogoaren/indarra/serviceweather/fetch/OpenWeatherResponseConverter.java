package com.gogoaren.indarra.serviceweather.fetch;

public class OpenWeatherResponseConverter {

    public Weather convert(OpenWeatherResponse openWeatherResponse) {
        return Weather.builder().city(openWeatherResponse.getName()).
                temperature(convertTemperature(openWeatherResponse.getMain().getTemp()))
                .humidity(openWeatherResponse.getMain().getHumidity())
                .build();
    }

    private double convertTemperature(double kelvineTemp) {
        return kelvineTemp - 273.15;
    }

}
