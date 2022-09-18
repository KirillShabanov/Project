package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerRepository extends JpaRepository<CarOwnerModel, Long> {

    static CarOwnerModel saveOwner(CarOwnerModel carOwnerModel) {
        return carOwnerModel;
    }
}
