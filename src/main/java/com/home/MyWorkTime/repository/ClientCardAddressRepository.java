package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.ClientCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientCardAddressRepository extends JpaRepository<ClientCardModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM clients_card WHERE client_full_name = :fullName ", nativeQuery = true)
    List<ClientCardModel> findClientForFullName(@Param("fullName") String fullName);

    @Transactional
    @Query(value = "SELECT * FROM clients_card WHERE city = :city ", nativeQuery = true)
    List<ClientCardModel> findClientForCity(@Param("city") String city);
}
