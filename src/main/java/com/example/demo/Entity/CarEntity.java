package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name ="car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;


    @Column(name = "year")
    private int manufacturingYear;

    @Column(name = "status")
    private String carStatus;

}
