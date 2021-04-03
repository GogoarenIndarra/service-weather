package com.gogoaren.indarra.serviceweather.controllers;


import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntityService;
import com.gogoaren.indarra.serviceweather.fetch.OpenWeatherFetcher;
import com.gogoaren.indarra.serviceweather.fetch.OpenWeatherResponse;
import com.gogoaren.indarra.serviceweather.fetch.OpenWeatherResponseConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/api/weather")
@RestController
@AllArgsConstructor
@Slf4j
public class WeatherController {

    private OpenWeatherFetcher openWeatherFetcher;

    private OpenWeatherResponseConverter converter;
    private WeatherEntityService weatherEntityService;

    @GetMapping(value = "/{city}")
    public WeatherEntity getWeatherByCity(@PathVariable String city) {
        log.info("fetching weather for: " + city);
        OpenWeatherResponse openWeatherResponse = openWeatherFetcher.fetchWeatherByCityName(city);
        log.info("open weather response: " + openWeatherResponse);

        WeatherEntity weatherEntity = converter.convert(openWeatherResponse);
        weatherEntityService.saveEntity(weatherEntity);
        return weatherEntity;
    }

//    @GetMapping(value = "/{}")
//    public OpenWeatherResponse getWeatherByCity(@PathVariable String city){
//        return openWeatherFetcher.fetchWeatherByCityName(city);
//    }


//
//    @GetMapping
//    public List<Vehicle> getVehicles(){
//        return vehicleService.findAllVehicles();
//    }
//
//    @GetMapping(value = "/filter")
//    public List<Vehicle> getVehiclesByColor(@RequestParam String color){
//        return vehicleService.findAllVehiclesByColor(color);
//    }
//
//    @GetMapping(value = "/{id}")
//    public Vehicle getVehicleById(@PathVariable Long id){
//        return vehicleService.findVehicleById(id);
//    }
//
//    @PostMapping
//    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
//        return vehicleService.saveVehicle(vehicle);
//    }
//
//    public @PostMapping(value = "/save-all")
//    List<Vehicle> saveVehicleList(@RequestBody List<Vehicle> vehicleList){
//        return vehicleService.saveVehicleList(vehicleList);
//    }
}
