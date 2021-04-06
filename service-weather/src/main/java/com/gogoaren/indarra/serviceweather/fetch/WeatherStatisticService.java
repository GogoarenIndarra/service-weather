package com.gogoaren.indarra.serviceweather.fetch;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface WeatherStatisticService {

    public Map<String, BigDecimal> findWarmestCity();
    public List<Map<String, BigDecimal>> findTopTenWarmestCity();
}
