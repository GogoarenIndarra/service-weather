package com.gogoaren.indarra.serviceweather.fetch;

import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntityService;
import com.gogoaren.indarra.serviceweather.fetch.openweather.OpenWeatherFetcher;
import com.gogoaren.indarra.serviceweather.fetch.openweather.OpenWeatherResponse;
import com.gogoaren.indarra.serviceweather.fetch.openweather.OpenWeatherResponseConverter;
import com.gogoaren.indarra.serviceweather.utils.CastomStringConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private OpenWeatherFetcher openWeatherFetcher;
    private OpenWeatherResponseConverter converter;
    private WeatherEntityService weatherEntityService;
    public static Long timeForWeatherExpire;

    @Autowired
    public void setTimeForWeatherExpire(@Value("${weather.expiration.time.ms}") Long value) {
        this.timeForWeatherExpire=value;
    }
    @Override
    public Weather getWeatherByCity(String city) {

        Optional<WeatherEntity> optionalWeatherEntity =
                weatherEntityService.findLatestStoredTemperature(city);
        if (optionalWeatherEntity.isPresent() && isWeatherActual(optionalWeatherEntity.get())) {

            log.info("weather from db: " + optionalWeatherEntity);
            return getWeather(optionalWeatherEntity);
        }
        log.info("fetching weather for: " + city);
        OpenWeatherResponse openWeatherResponse = openWeatherFetcher.fetchWeatherByCityName(city);
        log.info("open weather response: " + openWeatherResponse);
        Weather weather = converter.convert(openWeatherResponse);
        WeatherEntity weatherEntity = getWeatherEntity(weather);
        log.info("save weather entity: " + weatherEntity.toString());
        weatherEntityService.saveEntity(weatherEntity);
        return weather;
    }

    @Override
    public WeatherEntity getWeatherEntity(Weather weather) {
        return WeatherEntity.builder()
                .uuid(UUID.randomUUID())
                .created(Instant.now())
                .city(weather.getCity())
                .humidity(weather.getHumidity())
                .temperature(weather.getTemperature())
                .wind(weather.getWind())
                .country(weather.getCountry())
                .build();
    }

    @Override
    public Weather getWeather(Optional<WeatherEntity> optionalWeatherEntity) {
        WeatherEntity weatherEntity = optionalWeatherEntity.get();
        return Weather.builder()
                .humidity(weatherEntity.getHumidity())
                .city(weatherEntity.getCity())
                .temperature(weatherEntity.getTemperature())
                .wind(weatherEntity.getWind())
                .country(weatherEntity.getCountry())
                .build();
    }

    @Override
    public boolean isWeatherActual(WeatherEntity weatherEntity) {

        long time = weatherEntity.getCreated().toEpochMilli();
        long ct = Instant.now().toEpochMilli();
        long df = Math.abs(ct - time);

        if (df < timeForWeatherExpire) {
            return true;
        }
        return false;
    }
}
