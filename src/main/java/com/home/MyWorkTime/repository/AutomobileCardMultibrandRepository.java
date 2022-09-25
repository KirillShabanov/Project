package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardHavalModel;
import com.home.MyWorkTime.entity.AutomobileCardMultibrandModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobileCardMultibrandRepository extends JpaRepository<AutomobileCardMultibrandModel, Long> {

    static AutomobileCardMultibrandModel saveAutomobileCardMultibrandModel(AutomobileCardMultibrandModel automobileCardMultibrandModel){
        return automobileCardMultibrandModel;
    }
}
