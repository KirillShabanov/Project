package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.OrderOutfitModel;
import com.home.MyWorkTime.repository.OrderOutfitRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Slf4j
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

    @Scheduled(cron = "1 5 20 * * *")
    public void updateOrderFirstCall() throws IOException {
        FileInputStream filenamePost = new FileInputStream("C:/Users/User/Desktop/MyWorkTime/MyWorkTime/src/main/resources/importData/feedBack/firstCallKia.xls");
        Workbook wb = new HSSFWorkbook(filenamePost);
        for (int i = 0; i< wb.getSheetAt(0).getLastRowNum(); i++) {
            Date interDateFirstCall = wb.getSheetAt(0).getRow(i+1).getCell(7).getDateCellValue();
            int numOrder = (int) wb.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            orderOutfitRepository.updateOrderFirstCall(interDateFirstCall, numOrder);
        }
        filenamePost.close();


    }

    @Scheduled(cron = "2 5 20 * * *")
    public void updateOrderNpsCall() throws IOException {
        FileInputStream filenamePost = new FileInputStream("C:/Users/User/Desktop/MyWorkTime/MyWorkTime/src/main/resources/importData/feedBack/NPSkia.xls");
        Workbook wb = new HSSFWorkbook(filenamePost);
        for (int i = 0; i< wb.getSheetAt(0).getLastRowNum(); i++) {
            int numOrder = (int) wb.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            int interNps = (int) wb.getSheetAt(0).getRow(i+1).getCell(9).getNumericCellValue();
            Date interDateNpsCall = wb.getSheetAt(0).getRow(i+1).getCell(32).getDateCellValue();
            String interSet = wb.getSheetAt(0).getRow(i+1).getCell(33).getStringCellValue();
            orderOutfitRepository.updateOrderNpsCall(interSet, interNps, interDateNpsCall, numOrder);
        }
        filenamePost.close();
    }
}
