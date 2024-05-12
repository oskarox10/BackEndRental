package com.example.demo.Service;

import com.example.demo.Entity.CarEntity;
import com.example.demo.Enums.BrandEnum;
import com.example.demo.Enums.CarStatusEnum;
import com.example.demo.Mapper.CarMapper;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Request.CarRegistrationRequest;
import com.example.demo.Response.CarRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;


import java.util.ArrayList;
import java.util.List;

import static com.example.demo.Util.PatternUtil.CAR_ID_REGEX;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class TestService {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @Captor
    private ArgumentCaptor<CarEntity> carEntityCaptor;

    @Mock
    private CarMapper carMapper;

    private static final String CAR_ID = "CAR-123e4567-e89b-12d3-a456-426614174000";

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerShouldSucceed()
    {
        var request = generateCarRegistrationRequestStub();
        var entity = generateCarEntityStub();
        var response = generateCarRegistrationResponseStub();

        when(carMapper.requestToNewEntity(request)).thenReturn(entity);
        when(carRepository.save(any(CarEntity.class))).thenReturn(entity);
        when(carMapper.entityToResponse(entity)).thenReturn(response);

        var testResponse = carService.registerCar(request);

        verify(carMapper).requestToNewEntity(request);
        verify(carRepository).save(carEntityCaptor.capture());
        verify(carMapper).entityToResponse(entity);

        assertThat(carEntityCaptor.getValue()).isNotNull();
        assertThat(carEntityCaptor.getValue().getId()).containsPattern(CAR_ID_REGEX);
        assertThat(testResponse).usingRecursiveComparison().isEqualTo(entity);
    }


    @Test
    void findAll()
    {
        List<CarEntity> findAllCars = new ArrayList<>();

        when(carRepository.findAll()).thenReturn(findAllCars);

        List<CarEntity> findedAllCars = carRepository.findAll();

        assertEquals(findAllCars, findedAllCars);

        verify(carRepository, times(1)).findAll();

    }

    @Test
    void deleteAll()
    {
        doNothing().when(carRepository).deleteById(CAR_ID);

        carService.deleteById(CAR_ID);

        verify(carRepository, times(1)).deleteById(CAR_ID);
    }



    private CarRegistrationRequest generateCarRegistrationRequestStub()
    {
        return CarRegistrationRequest.builder()
                .brandEnum(BrandEnum.MERCEDES)
                .model("A45s")
                .manufacturingYear((short)2020)
                .carStatus(CarStatusEnum.ON_ROAD)
                .build();
    }

    private CarRegistrationResponse generateCarRegistrationResponseStub()
    {
        return CarRegistrationResponse.builder()
                .carId(CAR_ID)
                .brandEnum(BrandEnum.MERCEDES)
                .model("A45s")
                .manufacturingYear((short)2020)
                .carStatus(CarStatusEnum.ON_ROAD)
                .build();

    }


    private CarEntity generateCarEntityStub()
    {
        return CarEntity.builder()
                .id(CAR_ID)
                .brandEnum(BrandEnum.MERCEDES)
                .model("A45s")
                .manufacturingYear((short)2020)
                .carStatus(CarStatusEnum.ON_ROAD)
                .build();
    }




}
