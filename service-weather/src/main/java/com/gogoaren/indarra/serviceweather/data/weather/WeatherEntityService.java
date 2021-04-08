package com.gogoaren.indarra.serviceweather.data.weather;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class WeatherEntityService implements Serializable {

    private final WeatherEntityRepository weatherEntityRepository;

    public void saveEntity(final WeatherEntity weatherEntity) {
        log.info("weather from db: " + weatherEntity);
        weatherEntityRepository.save(weatherEntity);
    }

    public  Optional<WeatherEntity> findLatestStoredTemperature(String cityName) {
        return weatherEntityRepository.findLatestCityWeather(cityName);
    }

    public List<WeatherEntity> findTopWarmestCity(int numberOfRecords) {
        return weatherEntityRepository.findTopWarmestCity(numberOfRecords);
    }

}
