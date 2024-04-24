package com.example.demo.Converter;


import com.example.demo.Enums.CarStatusEnum;
import org.springframework.core.convert.converter.Converter;

public class CarStatusEnumConverter implements Converter<String, CarStatusEnum> {
    @Override
    public CarStatusEnum convert(String value) {
        return CarStatusEnum.fromValue(value);
    }
}
