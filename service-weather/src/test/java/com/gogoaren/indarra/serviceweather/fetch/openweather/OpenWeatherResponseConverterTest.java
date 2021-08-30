package com.gogoaren.indarra.serviceweather.fetch.openweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gogoaren.indarra.serviceweather.TestUtils;
import com.gogoaren.indarra.serviceweather.fetch.Weather;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenWeatherResponseConverterTest {


    OpenWeatherResponseConverter openWeatherResponseConverter = new OpenWeatherResponseConverter();

    @Test
    public void shouldConvertOpenWeatherResponse() throws Exception {

        Weather expectedWeather = Weather.builder()
                .country("Stany Zjednoczone")
                .wind(1.5)
                .city("Mountain View")
                .humidity(100)
                .temperature(BigDecimal.valueOf(9.41))
                .countryCode("US")
                .build();

        assertEquals(expectedWeather, openWeatherResponseConverter.convert(createOpenWeatherResponse()));

    }


    private OpenWeatherResponse createOpenWeatherResponse() throws Exception {

        String file =
                "src/test/java/com/gogoaren/indarra/serviceweather/utils/inputForTest_weatherResponseConverter.json";
        String jsonResponse = TestUtils.readFileAsString(file);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonResponse, OpenWeatherResponse.class);

    }

}