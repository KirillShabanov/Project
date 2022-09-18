package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarBrandModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBrandRepository extends JpaRepository<CarBrandModel, Long> {
}
