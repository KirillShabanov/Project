package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.SelectForTOModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface SelectForTORepository extends JpaRepository<SelectForTOModel, Long> {



    @Transactional
    @Query(value = "SELECT * " +
            "FROM to_regulations " +

            "WHERE FK_numTO = :selectTO AND FK_autoTO = :selectAuto ", nativeQuery = true)
     List<SelectForTOModel> findTOFromKey(@Param("selectTO") Long selectTO,
                                          @Param("selectAuto") Long selectAuto);


}

