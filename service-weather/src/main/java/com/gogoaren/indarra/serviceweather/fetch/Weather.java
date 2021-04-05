package com.gogoaren.indarra.serviceweather.fetch;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class Weather {

    private String city;
    private double temperature;
    private double humidity;
    private double wind;

}
