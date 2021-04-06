package com.gogoaren.indarra.serviceweather.fetch;

import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;


public interface WeatherService {

    public Weather getWeatherByCity(String city);

    public WeatherEntity getWeatherEntity(Weather weather);

    public Weather getWeather(Optional<WeatherEntity> optionalWeatherEntity);

    public boolean isWeatherActual(WeatherEntity weatherEntity);

}
