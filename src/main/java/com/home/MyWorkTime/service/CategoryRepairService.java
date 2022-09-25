package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.CategoryRepairModel;
import com.home.MyWorkTime.repository.CategoryRepairRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CategoryRepairService {

    private CategoryRepairRepository categoryRepairRepository;

    @Autowired
    public CategoryRepairService(CategoryRepairRepository categoryRepairRepository) {
        this.categoryRepairRepository = categoryRepairRepository;
    }

    public List<CategoryRepairModel> findAllCategory(String categoryRepair) {
        return categoryRepairRepository.findAll(categoryRepair);
    }
}
