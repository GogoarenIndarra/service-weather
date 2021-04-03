package com.gogoaren.indarra.serviceweather.data.weather;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;


@MappedSuperclass
@Access(value = AccessType.FIELD)
@DynamicInsert
@DynamicUpdate
public class WeatherEntity implements Serializable {

    private static final long serialVersionUID = 345L;

    @Id
    private UUID uuid;
    private String city;
    private Instant created;

}
