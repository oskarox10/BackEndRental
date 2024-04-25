package com.example.demo.Mapper;


import com.example.demo.Entity.CarEntity;
import com.example.demo.Request.CarRegistrationRequest;
import com.example.demo.Response.CarRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {


    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "carStatus", source = "carStatus")
    CarRegistrationResponse entityToResponse(CarRegistrationRequest carRegistrationRequest);

    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "carStatus", source = "carStatus")
    CarEntity requestToNewEntity(CarRegistrationRequest carRegistrationRequest);


    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "carStatus", source = "carStatus")
    CarEntity requestToUpdatedEntity(CarRegistrationRequest carRegistrationRequest, CarEntity carEntity);


}
