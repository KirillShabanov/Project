package com.home.MyWorkTime.service;

import com.home.MyWorkTime.repository.ReportAtlantKiaVinRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Service
@NoArgsConstructor
public class ReportAtlantKiaService {

    private ReportAtlantKiaVinRepository reportAtlantKiaVinRepository;

    @Autowired
    public ReportAtlantKiaService(ReportAtlantKiaVinRepository reportAtlantKiaVinRepository) {
        this.reportAtlantKiaVinRepository = reportAtlantKiaVinRepository;
    }

    @Scheduled(cron = "1 06 20 * * *")
    public void createFullOrderNps() throws IOException {
        FileInputStream filenamePost = new FileInputStream("C:/Users/User/IdeaProjects/Project/src/main/resources/importData/feedback/NPSkia.xls");
        Workbook wb = new HSSFWorkbook(filenamePost);
        for (int i = 0; i< wb.getSheetAt(0).getLastRowNum(); i++) {
            String brand = "KIA";
            int num_order = (int) wb.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            String vin = wb.getSheetAt(0).getRow(i+1).getCell(2).getStringCellValue();
            Date call_date = wb.getSheetAt(0).getRow(i+1).getCell(33).getDateCellValue();
            String administrator_name = wb.getSheetAt(0).getRow(i+1).getCell(34).getStringCellValue();
            int bq010 = (int) wb.getSheetAt(0).getRow(i+1).getCell(6).getNumericCellValue();
            int bq020 = (int) wb.getSheetAt(0).getRow(i+1).getCell(7).getNumericCellValue();
            int bq030 = (int) wb.getSheetAt(0).getRow(i+1).getCell(8).getNumericCellValue();
            String bq030_remark = wb.getSheetAt(0).getRow(i+1).getCell(9).getStringCellValue();
            int bq040 = (int) wb.getSheetAt(0).getRow(i+1).getCell(10).getNumericCellValue();
            int bq050 = (int) wb.getSheetAt(0).getRow(i+1).getCell(11).getNumericCellValue();
            String bq050_remark = wb.getSheetAt(0).getRow(i+1).getCell(12).getStringCellValue();
            int bq060 = (int) wb.getSheetAt(0).getRow(i+1).getCell(13).getNumericCellValue();
            int bq070 = (int) wb.getSheetAt(0).getRow(i+1).getCell(14).getNumericCellValue();
            int bq080 = (int) wb.getSheetAt(0).getRow(i+1).getCell(15).getNumericCellValue();
            String bq080_remark = wb.getSheetAt(0).getRow(i+1).getCell(16).getStringCellValue();
            int sq010 = 1;
            int sq020 = (int) wb.getSheetAt(0).getRow(i+1).getCell(17).getNumericCellValue();
            int sq030 = (int) wb.getSheetAt(0).getRow(i+1).getCell(18).getNumericCellValue();
            int sq040 = (int) wb.getSheetAt(0).getRow(i+1).getCell(19).getNumericCellValue();
            int sq050 = (int) wb.getSheetAt(0).getRow(i+1).getCell(20).getNumericCellValue();
            int sq060 = (int) wb.getSheetAt(0).getRow(i+1).getCell(21).getNumericCellValue();
            int sq070 = (int) wb.getSheetAt(0).getRow(i+1).getCell(22).getNumericCellValue();
            int sq080 = (int) wb.getSheetAt(0).getRow(i+1).getCell(23).getNumericCellValue();
            int sq090 = (int) wb.getSheetAt(0).getRow(i+1).getCell(24).getNumericCellValue();
            int sq110 = (int) wb.getSheetAt(0).getRow(i+1).getCell(25).getNumericCellValue();
            int sq120 = (int) wb.getSheetAt(0).getRow(i+1).getCell(26).getNumericCellValue();
            int sq130 = (int) wb.getSheetAt(0).getRow(i+1).getCell(27).getNumericCellValue();
            int sq140 = (int) wb.getSheetAt(0).getRow(i+1).getCell(28).getNumericCellValue();
            int dq010 = (int) wb.getSheetAt(0).getRow(i+1).getCell(29).getNumericCellValue();
            int dq020 = (int) wb.getSheetAt(0).getRow(i+1).getCell(30).getNumericCellValue();
            int dq030 = (int) wb.getSheetAt(0).getRow(i+1).getCell(5).getNumericCellValue();
            int dq040 = (int) wb.getSheetAt(0).getRow(i+1).getCell(32).getNumericCellValue();

            reportAtlantKiaVinRepository.createReportAtlantKia(brand, num_order, vin, call_date, administrator_name,
                    bq010, bq020, bq030, bq030_remark, bq040, bq050, bq050_remark, bq060,
                    bq070, bq080, bq080_remark, sq010, sq020, sq030, sq040, sq050, sq060, sq070,
                    sq080, sq090, sq110, sq120, sq130, sq140, dq010, dq020, dq030, dq040);
        }
        filenamePost.close();

        FileInputStream filenamePostMulti = new FileInputStream("C:/Users/User/IdeaProjects/Project/src/main/resources/importData/feedback/NPSmultibrand.xls");
        Workbook wbMulti = new HSSFWorkbook(filenamePostMulti);
        for (int i = 0; i< wbMulti.getSheetAt(0).getLastRowNum(); i++) {
            String brand = "Multibrand";
            int num_order = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(1).getNumericCellValue();
            String vin = wbMulti.getSheetAt(0).getRow(i+1).getCell(2).getStringCellValue();
            Date call_date = wbMulti.getSheetAt(0).getRow(i+1).getCell(33).getDateCellValue();
            String administrator_name = wbMulti.getSheetAt(0).getRow(i+1).getCell(34).getStringCellValue();
            int bq010 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(6).getNumericCellValue();
            int bq020 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(7).getNumericCellValue();
            int bq030 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(8).getNumericCellValue();
            String bq030_remark = wbMulti.getSheetAt(0).getRow(i+1).getCell(9).getStringCellValue();
            int bq040 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(10).getNumericCellValue();
            int bq050 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(11).getNumericCellValue();
            String bq050_remark = wbMulti.getSheetAt(0).getRow(i+1).getCell(12).getStringCellValue();
            int bq060 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(13).getNumericCellValue();
            int bq070 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(14).getNumericCellValue();
            int bq080 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(15).getNumericCellValue();
            String bq080_remark = wbMulti.getSheetAt(0).getRow(i+1).getCell(16).getStringCellValue();
            int sq010 = 1;
            int sq020 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(17).getNumericCellValue();
            int sq030 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(18).getNumericCellValue();
            int sq040 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(19).getNumericCellValue();
            int sq050 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(20).getNumericCellValue();
            int sq060 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(21).getNumericCellValue();
            int sq070 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(22).getNumericCellValue();
            int sq080 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(23).getNumericCellValue();
            int sq090 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(24).getNumericCellValue();
            int sq110 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(25).getNumericCellValue();
            int sq120 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(26).getNumericCellValue();
            int sq130 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(27).getNumericCellValue();
            int sq140 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(28).getNumericCellValue();
            int dq010 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(29).getNumericCellValue();
            int dq020 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(30).getNumericCellValue();
            int dq030 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(5).getNumericCellValue();
            int dq040 = (int) wbMulti.getSheetAt(0).getRow(i+1).getCell(32).getNumericCellValue();

            reportAtlantKiaVinRepository.createReportAtlantKia(brand, num_order, vin, call_date, administrator_name,
                    bq010, bq020, bq030, bq030_remark, bq040, bq050, bq050_remark, bq060,
                    bq070, bq080, bq080_remark, sq010, sq020, sq030, sq040, sq050, sq060, sq070,
                    sq080, sq090, sq110, sq120, sq130, sq140, dq010, dq020, dq030, dq040);
        }
        filenamePostMulti.close();

    }
}
