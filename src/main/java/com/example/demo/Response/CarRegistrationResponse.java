package com.example.demo.Response;

import com.example.demo.Enums.BrandEnum;
import com.example.demo.Enums.CarStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRegistrationResponse {

    private String carId;
    private BrandEnum brandEnum;
    private String model;
    private int manufacturingYear;
    private CarStatusEnum carStatus;
}
