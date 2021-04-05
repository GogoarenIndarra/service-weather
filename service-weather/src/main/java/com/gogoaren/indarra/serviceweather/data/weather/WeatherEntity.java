package com.gogoaren.indarra.serviceweather.data.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
//@MappedSuperclass
//@Access(value = AccessType.FIELD)
//@DynamicInsert
//@DynamicUpdate
@Table(name = "weather")
@Entity
public class WeatherEntity implements Serializable {

    private static final long serialVersionUID = 345L;

    @Id
    private UUID uuid;
    private String city;
    private Instant created;
    private Float temperature;
    private Float humidity;

}
