package com.gogoaren.indarra.serviceweather.fetch;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@AllArgsConstructor
public class OpenWeatherFetcher {

    private WebClient client;
    private String apiKey;

    public OpenWeatherResponse fetchWeatherByCity(String cityName) {

        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/")
                        .queryParam("q", cityName)
                        .queryParam("apiKey", apiKey)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(OpenWeatherResponse.class)
                .block(Duration.ofSeconds(2));
    }

}
