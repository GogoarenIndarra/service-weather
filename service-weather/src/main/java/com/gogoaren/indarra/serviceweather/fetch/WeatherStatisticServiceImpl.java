package com.gogoaren.indarra.serviceweather.fetch;

import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WeatherStatisticServiceImpl implements WeatherStatisticService {

    private final WeatherEntityService weatherEntityService;


    @Override
    public Map<String, BigDecimal> findWarmestCity() {

    return weatherEntityService.findTopWarmestCity(1).stream()
            .collect(Collectors.toMap(WeatherEntity::getCity, WeatherEntity::getTemperature));
    }

    @Override
    public Map<String, BigDecimal> findTopTenWarmestCity() {
        return weatherEntityService.findTopWarmestCity(10).stream()
                .collect(Collectors.toMap(WeatherEntity::getCity, WeatherEntity::getTemperature));
    }
}
