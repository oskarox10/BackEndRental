package com.example.demo.Service;

import com.example.demo.Entity.CarEntity;
import com.example.demo.Enums.BrandEnum;
import com.example.demo.Enums.CarStatusEnum;
import com.example.demo.Mapper.CarMapper;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Request.CarRegistrationRequest;
import com.example.demo.Response.CarRegistrationResponse;
import com.example.demo.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.Util.PatternUtil.CAR_ID_REGEX;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static org.junit.jupiter.api.Assertions.*;
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
        assertThat(testResponse).usingRecursiveComparison().isEqualTo(response);
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
    void getCarByIdShouldSucceed()
    {
        var entity = generateCarEntityStub();
        var response = generateCarRegistrationResponseStub();

        when(carRepository.findById(CAR_ID)).thenReturn(Optional.of(entity));
        when(carMapper.entityToResponse(entity)).thenReturn(response);

        var testResponse = carService.getCarById(CAR_ID);

        verify(carRepository).findById(CAR_ID);
        verify(carMapper).entityToResponse(entity);

        assertThat(testResponse).usingRecursiveComparison().isEqualTo(response);
    }



    @Test
    void getCarByIdShouldFailWhenCarNotRegistered()
    {
        when(carRepository.findById(CAR_ID)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> carService.getCarById(CAR_ID));

        verify(carRepository).findById(CAR_ID);
        verifyNoInteractions(carMapper);
    }


    @Test
    void deleteByIdShouldSucceed ()
    {
        when(carRepository.existsById(CAR_ID)).thenReturn(true);

        assertDoesNotThrow( () -> carService.deleteById(CAR_ID));

        verify(carRepository).existsById(CAR_ID);
        verify(carRepository).deleteById(CAR_ID);
    }

    @Test
    void deleteByIdShouldFail()
    {
        when(carRepository.existsById(CAR_ID)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> carService.deleteById(CAR_ID));

        verify(carRepository).existsById(CAR_ID);
        verifyNoMoreInteractions(carRepository);
    }

    @Test
    void updateCarShouldSucceed()
    {
        var request = generateCarRegistrationRequestStub();
        var response = generateCarRegistrationResponseStub();
        var entity = generateCarEntityStub();

        when(carRepository.findById(CAR_ID)).thenReturn(Optional.of(entity));
        when(carMapper.requestToUpdatedEntity(request, entity)).thenReturn(entity);
        when(carRepository.save(entity)).thenReturn(entity);
        when(carMapper.entityToResponse(entity)).thenReturn(response);

        var testResponse = carService.updateCarById(CAR_ID, request);

        verify(carRepository).findById(CAR_ID);
        verify(carMapper).requestToUpdatedEntity(request, entity);
        verify(carRepository).save(entity);
        verify(carMapper).entityToResponse(entity);

        assertThat(testResponse).usingRecursiveComparison().isEqualTo(response);
    }


    @Test
    void updateCarShouldFail ()
    {
        when(carRepository.findById(CAR_ID)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> carService.updateCarById(CAR_ID, generateCarRegistrationRequestStub()));

        verify(carRepository).findById(CAR_ID);
        verifyNoMoreInteractions(carRepository);
        verifyNoInteractions(carMapper);

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
