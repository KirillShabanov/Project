package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerSkodaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerSkodaRepository extends JpaRepository<CarOwnerSkodaModel, Long> {

    static CarOwnerSkodaModel saveOwnerSkoda(CarOwnerSkodaModel carOwnerSkodaModel) {
        return carOwnerSkodaModel;
    }
}
