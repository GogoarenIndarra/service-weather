package com.gogoaren.indarra.serviceweather.data.weather;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WeatherEntityService implements Serializable {

    private final WeatherEntityRepository weatherEntityRepository;

    public void saveEntity(final WeatherEntity weatherEntity) {
        weatherEntityRepository.save(weatherEntity);
    }

    public  Optional<WeatherEntity> findLatestStoredTemperature(String cityName) throws EntityNotFoundException {
        return weatherEntityRepository.findLatestCityWeather(cityName);
    }

}
