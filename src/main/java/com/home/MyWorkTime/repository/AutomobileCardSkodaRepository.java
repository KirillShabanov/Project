package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardSkodaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobileCardSkodaRepository extends JpaRepository<AutomobileCardSkodaModel, Long> {

    static AutomobileCardSkodaModel saveAutomobileCardSkodaModel(AutomobileCardSkodaModel automobileCardSkodaModel){
        return automobileCardSkodaModel;
    }
}
