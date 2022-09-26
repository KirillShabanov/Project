package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerMultibrandModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerMultibrandRepository extends JpaRepository<CarOwnerMultibrandModel, Long> {

    static CarOwnerMultibrandModel saveOwnerMultibrand(CarOwnerMultibrandModel carOwnerMultibrandModel) {
        return carOwnerMultibrandModel;
    }
}
