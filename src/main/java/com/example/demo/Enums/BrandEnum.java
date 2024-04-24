package com.example.demo.Enums;

public enum BrandEnum {

    MERCEDES ("mercedes"),
    BMW ("bmw"),
    AUDI ("audi"),
    ALFAROMEO("alfaromeo");


    private final String value;

    BrandEnum(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BrandEnum{" +
                "value='" + value + '\'' +
                '}';
    }
}
