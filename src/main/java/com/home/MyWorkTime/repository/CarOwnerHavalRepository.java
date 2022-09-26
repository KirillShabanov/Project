package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerHavalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerHavalRepository extends JpaRepository<CarOwnerHavalModel, Long> {

    static CarOwnerHavalModel saveOwner(CarOwnerHavalModel carOwnerHavalModel) {
        return carOwnerHavalModel;
    }
}
