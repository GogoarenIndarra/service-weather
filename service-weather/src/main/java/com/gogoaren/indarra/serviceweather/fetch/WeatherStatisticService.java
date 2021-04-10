package com.gogoaren.indarra.serviceweather.fetch;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface WeatherStatisticService {

    public Map<String, BigDecimal> findWarmestCity();
    public Map<String, BigDecimal> findTopTenWarmestCity();

    public Map<String, List<String>> findCitiesFromCountry(String country);
    public Map<String, BigDecimal> findMaxTemperatureForAllCities();
    public List<String> findCitiesWithTempTenDegreeOrHigher();
}