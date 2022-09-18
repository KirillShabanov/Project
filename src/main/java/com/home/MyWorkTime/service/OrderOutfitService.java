package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.OrderOutfitModel;
import com.home.MyWorkTime.repository.OrderOutfitRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class OrderOutfitService {


    private OrderOutfitRepository orderOutfitRepository;

    @Autowired
    public OrderOutfitService(OrderOutfitRepository orderOutfitRepository) {
        this.orderOutfitRepository = orderOutfitRepository;
    }

    public List<OrderOutfitModel> showTable() {
        return orderOutfitRepository.showTable();
    }

    public OrderOutfitModel addOrderOutfit(OrderOutfitModel orderOutfitModel) {
        OrderOutfitModel addOrderOutfit = orderOutfitRepository.save(orderOutfitModel);
        return orderOutfitRepository.save(addOrderOutfit);
    }
}
