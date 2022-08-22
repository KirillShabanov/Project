package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.ClientCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ClientCardPhoneRepository extends JpaRepository<ClientCardModel, Long> {

    @Transactional
    @Query(value = "SELECT * FROM clients_card WHERE phone = :phoneNum ", nativeQuery = true)
    List<ClientCardModel> findClientForPhone(@Param("phoneNum") Long phoneNum);
}
