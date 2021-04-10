package com.gogoaren.indarra.serviceweather.utils;

import org.apache.commons.lang3.StringUtils;

public class CastomStringConverter {

    public static String stringConvertforCity(String cityName) {
        return StringUtils.capitalize(StringUtils.lowerCase(cityName));

    }
}
