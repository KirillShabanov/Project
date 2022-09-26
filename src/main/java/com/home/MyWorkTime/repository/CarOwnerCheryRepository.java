package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerCheryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerCheryRepository extends JpaRepository<CarOwnerCheryModel, Long> {

    static CarOwnerCheryModel saveOwner(CarOwnerCheryModel carOwnerCheryModel) {
        return carOwnerCheryModel;
    }
}
