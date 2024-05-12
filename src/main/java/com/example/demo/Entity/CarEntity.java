package com.example.demo.Entity;


import com.example.demo.Enums.BrandEnum;
import com.example.demo.Enums.CarStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name ="car")
public class CarEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "brand")
    private BrandEnum brandEnum;

    @Column(name = "model")
    private String model;


    @Column(name = "year")
    private int manufacturingYear;

    @Column(name = "status")
    private CarStatusEnum carStatus;

}
