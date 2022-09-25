package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CategoryRepairModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryRepairRepository extends JpaRepository <CategoryRepairModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM category WHERE category LIKE :categoryRepair ",
    nativeQuery = true)
    List<CategoryRepairModel> findAll(@Param("categoryRepair") String categoryRepair);

}
