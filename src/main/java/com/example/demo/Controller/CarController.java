package com.example.demo.Controller;

import com.example.demo.Entity.CarEntity;
import com.example.demo.Request.CarRegistrationRequest;
import com.example.demo.Response.CarRegistrationResponse;
import com.example.demo.Service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.List;

import static com.example.demo.Util.PatternUtil.CAR_ID_REGEX;

@AllArgsConstructor
@RestController
@Validated
public class CarController {

    private final CarService carService;

    private static final String CAR_ID_REGEX_VALIDATION_MESSAGE = "Field 'carId' value must comply with pattern {regexp}";


    @GetMapping("/car/{carId}")
    CarRegistrationResponse getCarById (
            @Pattern(regexp = CAR_ID_REGEX,message = CAR_ID_REGEX_VALIDATION_MESSAGE)
            @PathVariable("carId") String carId)
    {
        return carService.getCarById(carId);
    }

    @PostMapping("/car")
    CarRegistrationResponse registerCar(@RequestBody CarRegistrationRequest request)
    {
        return carService.registerCar(request);
    }

    @GetMapping("/car")
    List<CarEntity> getAllCars()
    {
        return carService.getAllCars();
    }

    @PutMapping("/car/{carId}")
    CarRegistrationResponse updateCar(
            @Pattern(regexp = CAR_ID_REGEX,message = CAR_ID_REGEX_VALIDATION_MESSAGE)
            @PathVariable("carId") String carId,
            @RequestBody CarRegistrationRequest request)
    {
        return carService.updateCarById(carId, request);
    }


    @DeleteMapping("/car/{carId}")
    void deleteCarById(
            @Pattern(regexp = CAR_ID_REGEX,message = CAR_ID_REGEX_VALIDATION_MESSAGE)
            @PathVariable("carId") String carId)
    {
        carService.deleteById(carId);
    }



}
