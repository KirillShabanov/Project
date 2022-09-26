package com.home.MyWorkTime.repository;


import com.home.MyWorkTime.entity.CarOwnerFordModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerFordRepository extends JpaRepository<CarOwnerFordModel, Long> {

    static CarOwnerFordModel saveOwner(CarOwnerFordModel carOwnerFordModel) {
        return carOwnerFordModel;
    }
}
