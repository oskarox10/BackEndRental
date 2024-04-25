package com.example.demo.Repository;

import com.example.demo.Entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, String> {
}
