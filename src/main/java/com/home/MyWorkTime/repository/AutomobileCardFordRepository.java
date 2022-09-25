package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardCheryModel;
import com.home.MyWorkTime.entity.AutomobileCardFordModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobileCardFordRepository extends JpaRepository<AutomobileCardFordModel, Long> {

    static AutomobileCardFordModel saveAutomobileCardFordModel(AutomobileCardFordModel automobileCardFordModel){
        return automobileCardFordModel;
    }
}
