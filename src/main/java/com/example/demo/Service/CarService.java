package com.example.demo.Service;

import com.example.demo.Entity.CarEntity;
import com.example.demo.Mapper.CarMapper;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Request.CarRegistrationRequest;
import com.example.demo.Response.CarRegistrationResponse;
import com.example.demo.Util.PatternUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final CarMapper carMapper;

    private static final String CREATED = "created";
    private static final String CAR_RESOURCE = "Car";


    public CarRegistrationResponse registerCar(CarRegistrationRequest request) {
        var entity = carMapper.requestToNewEntity(request);
        entity.setId(PatternUtil.generateId());

        entity = carRepository.save(entity);
        return carMapper.entityToResponse(entity);
    }


    public CarRegistrationResponse getCarById(String carId)
    {
        var entity = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException(carId));

        return carMapper.entityToResponse(entity);
    }



    public List<CarEntity> getAllCars()
    {
        return  carRepository.findAll();
    }



    public CarRegistrationResponse updateCarById(String carId, CarRegistrationRequest request)
    {
        var entity = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException(carId));

        entity = carMapper.requestToUpdatedEntity(request, entity);




        entity = carRepository.save(entity);
        return carMapper.entityToResponse(entity);
    }

    public void deleteById(String carId) {
        if (carRepository.existsById(carId))
            carRepository.deleteById(carId);
    }

}
