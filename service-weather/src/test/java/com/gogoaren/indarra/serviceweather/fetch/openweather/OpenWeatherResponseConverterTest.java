package com.gogoaren.indarra.serviceweather.fetch.openweather;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gogoaren.indarra.serviceweather.fetch.Weather;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OpenWeatherResponseConverterTest {


    OpenWeatherResponseConverter openWeatherResponseConverter = new OpenWeatherResponseConverter();

    @Test
    public void shouldConvertOpenWeatherResponse() throws JsonProcessingException {

        Weather expectedWeather = Weather.builder()
                .country("Stany Zjednoczone")
                .wind(1.5)
                .city("Mountain View")
                .humidity(100)
                .temperature(BigDecimal.valueOf(9.41))
                .countryCode("US")
                .build();

        Assert.assertEquals(expectedWeather, openWeatherResponseConverter.convert(createOpenWeatherResponse()));

    }


    private OpenWeatherResponse createOpenWeatherResponse() throws JsonProcessingException {
        //TODO move to file
        String jsonResponse = "{\n" +
                "  \"weather\": [\n" +
                "    {\n" +
                "      \"id\": 800,\n" +
                "      \"main\": \"Clear\",\n" +
                "      \"description\": \"clear sky\",\n" +
                "      \"icon\": \"01d\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"main\": {\n" +
                "    \"temp\": 282.55,\n" +
                "    \"feels_like\": 281.86,\n" +
                "    \"temp_min\": 280.37,\n" +
                "    \"temp_max\": 284.26,\n" +
                "    \"pressure\": 1023,\n" +
                "    \"humidity\": 100\n" +
                "  },\n" +
                "  \"visibility\": 16093,\n" +
                "  \"wind\": {\n" +
                "    \"speed\": 1.5,\n" +
                "    \"deg\": 350\n" +
                "  },\n" +
                "  \"sys\": {\n" +
                "    \"type\": 1,\n" +
                "    \"id\": 5122,\n" +
                "    \"message\": 0.0139,\n" +
                "    \"country\": \"US\",\n" +
                "    \"sunrise\": 1560343627,\n" +
                "    \"sunset\": 1560396563\n" +
                "  },\n" +
                "  \"timezone\": -25200,\n" +
                "  \"name\": \"Mountain View\",\n" +
                "  \"cod\": 200\n" +
                "  }                         \n";

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonResponse, OpenWeatherResponse.class);

    }

}