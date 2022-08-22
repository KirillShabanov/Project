package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.ClientCardModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientCardRepository extends JpaRepository<ClientCardModel, Long> {

    static ClientCardModel saveClient(ClientCardModel clientCardModel){
       return clientCardModel;
    }
}
