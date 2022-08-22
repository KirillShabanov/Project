package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.SelectForTOModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

public interface SelectForTORepository extends JpaRepository<SelectForTOModel, Long> {



    @Transactional
    @Query(value = "SELECT jobCode, jobName, jobTime, partNumber, partName, amount, partPrice " +
            "FROM to_regulations " +
            "INNER JOIN regulations ON to_regulations.FK_numTO = regulations.id " +
            "INNER JOIN auto ON to_regulations.FK_autoTO = auto.id " +
            "INNER JOIN part ON to_regulations.FK_part_numberTO = part.id " +
            "INNER JOIN normalization ON to_regulations.FK_job_codeTO = normalization.id " +
            "WHERE FK_numTO = :selectTO AND FK_autoTO = :selectAuto ", nativeQuery = true)
    List<Map<String, String>> findTOFromKey(@Param("selectTO") Long selectTO,
                                            @Param("selectAuto") Long selectAuto);


}

