package com.example.demo.Mapper;


import com.example.demo.Entity.CarEntity;
import com.example.demo.Request.CarRegistrationRequest;
import com.example.demo.Response.CarRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface CarMapper {


    @Mapping(target = "brandEnum", source = "brandEnum")
    @Mapping(target = "carStatus", source = "carStatus")
    CarRegistrationResponse entityToResponse(CarEntity carEntity);

    @Mapping(target = "brandEnum", source = "brandEnum")
    @Mapping(target = "carStatus", source = "carStatus")
    CarEntity requestToNewEntity(CarRegistrationRequest carRegistrationRequest);


    @Mapping(target = "brandEnum", source = "brandEnum")
    @Mapping(target = "carStatus", source = "carStatus")
    CarEntity requestToUpdatedEntity(CarRegistrationRequest carRegistrationRequest,@MappingTarget CarEntity carEntity);


}
