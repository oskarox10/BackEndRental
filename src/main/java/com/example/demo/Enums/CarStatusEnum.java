package com.example.demo.Enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CarStatusEnum {

    ON_ROAD("on_road"),
    IN_REPAIR("in_repair"),
    NOT_USED("not_used");


    private final String value;

    CarStatusEnum(String value) {
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


    public static CarStatusEnum fromValue(String value)
    {
        for (CarStatusEnum x: CarStatusEnum.values())
        {
            if (x.value.equals(value))
            {
                return x;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
