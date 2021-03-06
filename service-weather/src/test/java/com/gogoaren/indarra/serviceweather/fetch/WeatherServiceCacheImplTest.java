package com.gogoaren.indarra.serviceweather.fetch;

import com.gogoaren.indarra.serviceweather.fetch.openweather.OpenWeatherFetcher;
import com.gogoaren.indarra.serviceweather.fetch.openweather.OpenWeatherResponse;
import com.gogoaren.indarra.serviceweather.fetch.openweather.OpenWeatherResponseConverter;
import com.gogoaren.indarra.serviceweather.kafka.KafkaMessageSender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class WeatherServiceCacheImplTest {

    private final OpenWeatherFetcher openWeatherFetcher = mock(OpenWeatherFetcher.class);
    private final OpenWeatherResponseConverter converter = mock(OpenWeatherResponseConverter.class);
    private final KafkaMessageSender kafkaMessageSender = mock(KafkaMessageSender.class);
    private final Weather mockWeather = mock(Weather.class);

    private final OpenWeatherResponse openWeatherResponse = new OpenWeatherResponse();
    private WeatherServiceCacheImpl serviceCache;

    @BeforeEach
    public void setUp() {
        serviceCache = new WeatherServiceCacheImpl(openWeatherFetcher, converter, kafkaMessageSender);
        Mockito.when(openWeatherFetcher.fetchWeatherByCityName(anyString())).thenReturn(openWeatherResponse);
        Mockito.when(converter.convert(openWeatherResponse)).thenReturn(mockWeather);
    }


    @Test
    public void shouldCallExternalServiceOneTimeWhenTwoCallsForTheSameCityMadeTwice() {
        //when:
        serviceCache.getWeatherByCity("London");
        serviceCache.getWeatherByCity("London");

        //then
        Mockito.verify(openWeatherFetcher, times(1)).fetchWeatherByCityName(anyString());
        Mockito.verify(kafkaMessageSender, times(1)).sendMessage(any());

    }

    @Test
    public void shouldCallExternalServiceTwiceWhenTwoCallsForDifferentCityMade() {
        //when:
        serviceCache.getWeatherByCity("London");
        serviceCache.getWeatherByCity("Prague");

        //then
        Mockito.verify(openWeatherFetcher, times(2)).fetchWeatherByCityName(anyString());
        Mockito.verify(kafkaMessageSender, times(2)).sendMessage(any());
    }

    @Test
    public void clearCacheTest() {


        //when //then
//        serviceCache.getWeatherByCity("Konin");
//        Assertions.assertThat(serviceCache.cacheWeatherMap.containsKey("Konin"));
//        serviceCache.clearCache();
//        Assertions.assertThat(serviceCache.cacheWeatherMap.isEmpty());



    }

}