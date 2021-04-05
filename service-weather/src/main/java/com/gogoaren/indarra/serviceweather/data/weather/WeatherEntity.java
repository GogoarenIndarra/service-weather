package com.gogoaren.indarra.serviceweather.data.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@Table(name = "weather")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntity implements Serializable {

    private static final long serialVersionUID = 345L;

    @Id
    private UUID uuid;
    private Instant created;
    private String city;
    private double temperature;
    private double humidity;
    private double wind;


}
