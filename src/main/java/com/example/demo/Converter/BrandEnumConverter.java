package com.example.demo.Converter;

import com.example.demo.Enums.BrandEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BrandEnumConverter implements Converter<String, BrandEnum> {
    @Override
    public BrandEnum convert(String value) {
        return BrandEnum.fromValue(value);
    }
}
