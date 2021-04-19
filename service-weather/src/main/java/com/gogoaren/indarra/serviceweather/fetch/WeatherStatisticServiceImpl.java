package com.gogoaren.indarra.serviceweather.fetch;

import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

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

    @Override
    public Map<String, List<String>> findCitiesFromCountry(String countryCode) {
        Set<String> distinctCity = weatherEntityService.selectAllForStreamPractice().stream()
                .filter(w -> countryCode.equals(w.getCountryCode())).map(WeatherEntity::getCity).collect(toSet());
        Map<String, List<String>> result = new HashMap<>();
        result.put(countryCode, List.copyOf(distinctCity));
        return result;
    }

    public Map<String, Set<String>> findCitiesFromAllCountries() {
        return null;
//        weatherEntityService.selectAllForStreamPractice().stream().
//                collect(Collectors.groupingBy(WeatherEntity::getCountryCode));
    }

    @Override
    public Map<String, BigDecimal> findMaxTemperatureForAllCities() {
        return null;
    }

    @Override
    public Set<String> findCitiesWithTempTenDegreeOrHigher() {

        return weatherEntityService.selectAllForStreamPractice()
                .stream()
                .filter(w -> w.getTemperature().compareTo(BigDecimal.valueOf(10)) >= 0)
                .map(weatherEntity -> weatherEntity.getCity())
                .collect(Collectors.toSet());

    }
}
