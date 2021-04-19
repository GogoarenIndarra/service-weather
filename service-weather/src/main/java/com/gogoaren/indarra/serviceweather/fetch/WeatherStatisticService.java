package com.gogoaren.indarra.serviceweather.fetch;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface WeatherStatisticService {

    public Map<String, BigDecimal> findWarmestCity();

    public Map<String, BigDecimal> findTopTenWarmestCity();

    public Map<String, List<String>> findCitiesFromCountry(String countryCode);

    public Map<String, BigDecimal> findMaxTemperatureForAllCities();

    public Set<String> findCitiesWithTempTenDegreeOrHigher();
}