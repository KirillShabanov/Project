package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardCheryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobileCardCheryRepository extends JpaRepository<AutomobileCardCheryModel, Long> {

    static AutomobileCardCheryModel saveAutomobileCardCheryModel(AutomobileCardCheryModel automobileCardCheryModel){
        return automobileCardCheryModel;
    }
}
