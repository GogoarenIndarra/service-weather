package com.gogoaren.indarra.serviceweather.fetch;

import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntityService;
import com.gogoaren.indarra.serviceweather.fetch.openweather.OpenWeatherFetcher;
import com.gogoaren.indarra.serviceweather.fetch.openweather.OpenWeatherResponse;
import com.gogoaren.indarra.serviceweather.fetch.openweather.OpenWeatherResponseConverter;
import com.gogoaren.indarra.serviceweather.kafka.KafkaMessageSender;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


@Service
@AllArgsConstructor
@Slf4j
public class WeatherServiceCacheImpl implements WeatherService {

    private final OpenWeatherFetcher openWeatherFetcher;
    private final OpenWeatherResponseConverter converter;
    private  final KafkaMessageSender kafkaMessageSender;

    private final Map<String,Weather> cacheWeatherMap = new ConcurrentHashMap<>();


    @Override
    public Weather getWeatherByCity(String city) {

        // can be replaced but log miss
       // return cacheWeatherMap.getOrDefault(city, getWeatherFromOenWeather(city));
        if (cacheWeatherMap.containsKey(city)) {
            log.info("weather from cache: " + city);
            return cacheWeatherMap.get(city);
        }
        return getWeatherFromOenWeather(city);

    }

    private Weather getWeatherFromOenWeather(String city) {
        log.info("fetching weather for: " + city);
        OpenWeatherResponse openWeatherResponse = openWeatherFetcher.fetchWeatherByCityName(city);
        log.info("open weather response: " + openWeatherResponse);
        Weather weather = converter.convert(openWeatherResponse);
        cacheWeatherMap.put(city, weather);
        kafkaMessageSender.sendMessage(weather);
        return weather;
    }

}
