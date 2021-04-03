package com.gogoaren.indarra.serviceweather.fetch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OpenWeatherResponse {

    @JsonProperty("weather")
    private List<Weather> weather;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("timezone")
    private Integer timezone;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Integer cod;


    @Data
    @NoArgsConstructor
    public static class Weather {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("main")
        private String main;
        @JsonProperty("description")
        private String description;
        @JsonProperty("icon")
        private String icon;
    }

    @Data
    @NoArgsConstructor
    public static class Wind {
        @JsonProperty("speed")
        private Float speed;
        @JsonProperty("deg")
        private Integer deg;

    }

    @Data
    @NoArgsConstructor
    public static class Sys {
        @JsonProperty("type")
        private Integer type;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("message")
        private Float message;
        @JsonProperty("country")
        private String country;
        @JsonProperty("sunrise")
        private Integer sunrise;
        @JsonProperty("sunset")
        private Integer sunset;
    }

    @Data
    @NoArgsConstructor
    public static class Main {
        @JsonProperty("temp")
        private Float temp;
        @JsonProperty("feels_like")
        private Float feelsLike;
        @JsonProperty("temp_min")
        private Float tempMin;
        @JsonProperty("temp_max")
        private Float tempMax;
        @JsonProperty("pressure")
        private Integer pressure;
        @JsonProperty("humidity")
        private Integer humidity;

    }
}
