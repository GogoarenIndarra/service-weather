//package com.gogoaren.indarra.serviceweather.fetch;
//
//import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntity;
//import com.gogoaren.indarra.serviceweather.data.weather.WeatherEntityService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.math.BigDecimal;
//import java.time.Instant;
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.doReturn;
//
//@RunWith(MockitoJUnitRunner.class)
//public class WeatherStatisticServiceImplTest {
//
//
//    @Mock
//    private WeatherEntityService weatherEntityService;
//    @InjectMocks
//    private WeatherStatisticService weatherStatisticService =
//            new WeatherStatisticServiceImpl(weatherEntityService);
//
//    @BeforeEach
//    private void setUpRepo(){
//        WeatherEntity weather1 = new WeatherEntity();
//        weather1.setCity("London");
//        weather1.setCreated(Instant.now());
//        weather1.setUuid(UUID.randomUUID());
//        weather1.setTemperature(BigDecimal.valueOf(25));
//        weather1.setHumidity(56);
//        weather1.setWind(5);
//
//
//
//
//
//        Iterable<WeatherEntity> actual = Arrays.asList(weather1);
//        doReturn(actual).when(weatherEntityService).findTopWarmestCity(1);
//        doReturn(Arrays.asList(weather1)).when(weatherEntityService).findTopWarmestCity(1);
//
////        doReturn(Arrays.asList(vehicle1)).when(vehicleRepository).findAllByColor("red");
////        vehicleService = new VehicleServiceImpl(vehicleRepository);
//    }
//
//
//    @Test
//    public void sholudReturnSelectedColor(){
//
//        //when
//        List<WeatherEntity> actual = weatherEntityService.findTopWarmestCity(1);
//        //then
////        Assertions.assertEquals("red", actual.get(0).getColor());
////        Assertions.assertEquals("model", actual.get(0).getModel());
////        Assertions.assertEquals("brand", actual.get(0).getBrand());
////        Assertions.assertEquals(1L, actual.get(0).getId());
//
//    }
//
////    @Test
////    public void sholudNotReturnAnyColor(){
////
////        //when
////        List<Vehicle> actual = vehicleService.findAllVehiclesByColor("black");
////        //then
////        assertTrue(actual.isEmpty());
////
////    }
//
////    @Mock
////    private WeatherEntityService weatherEntityService;
////    @InjectMocks
////    private WeatherStatisticService weatherStatisticService =
////            new WeatherStatisticServiceImpl(weatherEntityService);
////
////    @Test
////    public void serviceShuldTransformEntitytToMapWithOneRecord() {
////        final String city = "London";
////        final double temp = 123;
////        //givem
////
////        Mockito.when(weatherEntityService.findTopWarmestCity(1)).thenReturn(Arrays.asList(createWeatherEntity(city, temp)));
////        //when
////        var result = weatherStatisticService.findWarmestCity();
////        //then
////        Assertions.assertEquals(1, result.size());
////        Assertions.assertEquals(new BigDecimal(temp), result.get(city));
////
////    }
////
////    private WeatherEntity createWeatherEntity(String city, double temperature) {
////        return WeatherEntity.builder()
////                .city(city)
////                .temperature(new BigDecimal(temperature))
////                .build();
////    }
//
//}