package com.example.demo.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BrandEnum {

    MERCEDES ("mercedes"),
    BMW ("bmw"),
    AUDI ("audi"),
    ALFA("alfa");


    private final String value;

    BrandEnum(String value) {
        this.value = value;
    }


    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static BrandEnum fromValue(String value)
    {
        for (BrandEnum x : BrandEnum.values())
        {
            if (x.value.equals(value))
            {
                return x;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
