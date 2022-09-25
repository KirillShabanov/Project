package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardHavalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobileCardHavalRepository extends JpaRepository<AutomobileCardHavalModel, Long> {

    static AutomobileCardHavalModel saveAutomobileCardHavalModel(AutomobileCardHavalModel automobileCardHavalModel){
        return automobileCardHavalModel;
    }
}
