package com.gogoaren.indarra.serviceweather.controllers;


import com.gogoaren.indarra.serviceweather.fetch.OpenWeatherFetcher;
import com.gogoaren.indarra.serviceweather.fetch.OpenWeatherResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/api/weather")
@RestController
@AllArgsConstructor
@Slf4j
public class WeatherController {

   private OpenWeatherFetcher openWeatherFetcher;

    @GetMapping(value = "/{city}")
    public OpenWeatherResponse getWeatherByCity(@PathVariable String city){
        log.info("fetching weather for: " + city);
        return openWeatherFetcher.fetchWeatherByCityName(city);
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
