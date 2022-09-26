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

    @Scheduled(cron = "1 0 20 * * *")
    public void updateOrderFirstCallKia() throws IOException {
        FileInputStream filenamePost = new FileInputStream("C:/Users/User/IdeaProjects/Project/src/main/resources/importData/feedback/firstCallKia.xls");
        Workbook wb = new HSSFWorkbook(filenamePost);
        for (int i = 0; i< wb.getSheetAt(0).getLastRowNum(); i++) {
            Date interDateFirstCall = wb.getSheetAt(0).getRow(i+1).getCell(7).getDateCellValue();
            int numOrder = (int) wb.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            orderOutfitRepository.updateOrderFirstCall(interDateFirstCall, numOrder);
        }
        filenamePost.close();
    }

    @Scheduled(cron = "1 01 20 * * *")
    public void updateOrderFirstCallMultibrand() throws IOException {
        FileInputStream filenamePost = new FileInputStream("C:/Users/User/IdeaProjects/Project/src/main/resources/importData/feedback/firstCallMultibrand.xls");
        Workbook wb = new HSSFWorkbook(filenamePost);
        for (int i = 0; i< wb.getSheetAt(0).getLastRowNum(); i++) {
            Date interDateFirstCall = wb.getSheetAt(0).getRow(i+1).getCell(7).getDateCellValue();
            int numOrder = (int) wb.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            orderOutfitRepository.updateOrderFirstCall(interDateFirstCall, numOrder);
        }
        filenamePost.close();
    }

    @Scheduled(cron = "1 02 20 * * *")
    public void updateOrderFirstCallSkoda() throws IOException {
        FileInputStream filenamePost = new FileInputStream("C:/Users/User/IdeaProjects/Project/src/main/resources/importData/feedback/firstCallSkoda.xls");
        Workbook wb = new HSSFWorkbook(filenamePost);
        for (int i = 0; i< wb.getSheetAt(0).getLastRowNum(); i++) {
            Date interDateFirstCall = wb.getSheetAt(0).getRow(i+1).getCell(7).getDateCellValue();
            int numOrder = (int) wb.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            orderOutfitRepository.updateOrderFirstCall(interDateFirstCall, numOrder);
        }
        filenamePost.close();
    }

    @Scheduled(cron = "1 03 20 * * *")
    public void updateOrderNpsCallKia() throws IOException {
        FileInputStream filenamePost = new FileInputStream("C:/Users/User/IdeaProjects/Project/src/main/resources/importData/feedback/NPSkia.xls");
        Workbook wb = new HSSFWorkbook(filenamePost);
        for (int i = 0; i< wb.getSheetAt(0).getLastRowNum(); i++) {
            int numOrder = (int) wb.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            int interNps = (int) wb.getSheetAt(0).getRow(i+1).getCell(10).getNumericCellValue();
            Date interDateNpsCall = wb.getSheetAt(0).getRow(i+1).getCell(33).getDateCellValue();
            String interSet = wb.getSheetAt(0).getRow(i+1).getCell(34).getStringCellValue();
            orderOutfitRepository.updateOrderNpsCall(interSet, interNps, interDateNpsCall, numOrder);
        }
        filenamePost.close();
    }

    @Scheduled(cron = "1 04 20 * * *")
    public void updateOrderNpsCallMultibrand() throws IOException {
        FileInputStream filenamePost = new FileInputStream("C:/Users/User/IdeaProjects/Project/src/main/resources/importData/feedback/NPSmultibrand.xls");
        Workbook wb = new HSSFWorkbook(filenamePost);
        for (int i = 0; i< wb.getSheetAt(0).getLastRowNum(); i++) {
            int numOrder = (int) wb.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            int interNps = (int) wb.getSheetAt(0).getRow(i+1).getCell(10).getNumericCellValue();
            Date interDateNpsCall = wb.getSheetAt(0).getRow(i+1).getCell(33).getDateCellValue();
            String interSet = wb.getSheetAt(0).getRow(i+1).getCell(34).getStringCellValue();
            orderOutfitRepository.updateOrderNpsCall(interSet, interNps, interDateNpsCall, numOrder);
        }
        filenamePost.close();
    }

    @Scheduled(cron = "1 05 20 * * *")
    public void updateOrderNpsCallSkoda() throws IOException {
        FileInputStream filenamePost = new FileInputStream("C:/Users/User/IdeaProjects/Project/src/main/resources/importData/feedback/NPSskoda.xls");
        Workbook wb = new HSSFWorkbook(filenamePost);
        for (int i = 0; i< wb.getSheetAt(0).getLastRowNum(); i++) {
            int numOrder = (int) wb.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            int interNps = (int) wb.getSheetAt(0).getRow(i+1).getCell(6).getNumericCellValue();
            Date interDateNpsCall = wb.getSheetAt(0).getRow(i+1).getCell(7).getDateCellValue();
            String interSet = wb.getSheetAt(0).getRow(i+1).getCell(8).getStringCellValue();
            orderOutfitRepository.updateOrderNpsCall(interSet, interNps, interDateNpsCall, numOrder);
        }
        filenamePost.close();
    }
}
