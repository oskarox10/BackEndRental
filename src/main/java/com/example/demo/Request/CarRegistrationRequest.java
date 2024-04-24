package com.example.demo.Request;

import com.example.demo.Enums.BrandEnum;
import com.example.demo.Enums.CarStatusEnum;
import com.example.demo.Validator.ManufacturingYearRange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarRegistrationRequest {

    @NotNull(message = "year cannot be null")
    @ManufacturingYearRange
    private int year;

    @NotNull(message = "brand cannot be null")
    private BrandEnum brandEnum;

    @Size(min = 2, max = 250, message = "model cannot be null")
    private String model;

    @NotNull(message = "car status cannot be null")
    private CarStatusEnum carStatus;

}
