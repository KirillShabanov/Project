package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardKiaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobileCardKiaRepository extends JpaRepository<AutomobileCardKiaModel, Long> {

    static AutomobileCardKiaModel saveAutomobileCardKiaModel(AutomobileCardKiaModel automobileCardKiaModel){
        return automobileCardKiaModel;
    };
}
