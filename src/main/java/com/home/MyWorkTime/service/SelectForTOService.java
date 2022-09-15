package com.home.MyWorkTime.service;

import com.home.MyWorkTime.repository.SelectForTORepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@NoArgsConstructor
public class SelectForTOService {

    private SelectForTORepository selectForTORepository;

    @Autowired
    public SelectForTOService(SelectForTORepository selectForTORepository) {
        this.selectForTORepository = selectForTORepository;
    }

    public List<Map<String, String>> findTOFromKey(Long selectTO, Long selectAuto) {
        return selectForTORepository.findTOFromKey(selectTO, selectAuto);
    }
}
