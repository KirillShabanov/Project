package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.SelectForTOModel;
import com.home.MyWorkTime.repository.SelectForTORepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@NoArgsConstructor
public class SelectForTOService {

    @Autowired
    private SelectForTORepository selectForTORepository;

    public List<SelectForTOModel> findTOFromKey(Long selectTO, Long selectAuto) {
        System.err.println("Запрос прошёл вооооот сюда!  SelectForTOService");
        return selectForTORepository.findTOFromKey(selectTO, selectAuto);
    }
}
