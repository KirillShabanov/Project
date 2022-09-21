package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.KiaMailOrderModel;
import com.home.MyWorkTime.repository.KiaMailOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.List;



@Slf4j
@Service
public class KiaMailOrderService {

    private final KiaMailOrderRepository kiaMailOrderRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public KiaMailOrderService(KiaMailOrderRepository kiaMailOrderRepository, JavaMailSender javaMailSender) {
        this.kiaMailOrderRepository = kiaMailOrderRepository;
        this.javaMailSender = javaMailSender;
    }


    @Scheduled(fixedDelay = 50000)
    public void createExcelKiaCall() {
        List<KiaMailOrderModel> firstCall = kiaMailOrderRepository.getFirstCall();
        List<KiaMailOrderModel> npsCall = kiaMailOrderRepository.getNPSCall();

        try {
            // Создают Excel файл
            String filenamePost = "C:/Users/User/Desktop/ПостСервисныйОбзвон.xls";
            HSSFWorkbook workbookFirstCall = new HSSFWorkbook();
            HSSFSheet sheetFirstCall = workbookFirstCall.createSheet("ПостСервисныйОбзвон");

            //Шапка
            HSSFRow rowheadFirstCall = sheetFirstCall.createRow((short)0);
            rowheadFirstCall.createCell(0).setCellValue("No.");
            rowheadFirstCall.createCell(1).setCellValue("Номер ЗН");
            rowheadFirstCall.createCell(2).setCellValue("VIN");
            rowheadFirstCall.createCell(3).setCellValue("Телефон");
            rowheadFirstCall.createCell(4).setCellValue("ФИО");
            rowheadFirstCall.createCell(5).setCellValue("Замечания");
            rowheadFirstCall.createCell(6).setCellValue("Примечания");


            for (int i=0; i< firstCall.size(); i++) {
                //Строки
                HSSFRow rowFirstCall = sheetFirstCall.createRow((short) i+1);
                rowFirstCall.createCell(0).setCellValue(i + 1);
                rowFirstCall.createCell(1).setCellValue(firstCall.get(i).getNum_order());
                rowFirstCall.createCell(2).setCellValue(firstCall.get(i).getVin());
                rowFirstCall.createCell(3).setCellValue(firstCall.get(i).getPhone());
                rowFirstCall.createCell(4).setCellValue(firstCall.get(i).getClient_name());
                sheetFirstCall.autoSizeColumn(0);
                sheetFirstCall.autoSizeColumn(1);
                sheetFirstCall.autoSizeColumn(2);
                sheetFirstCall.autoSizeColumn(3);
                sheetFirstCall.autoSizeColumn(4);
                sheetFirstCall.autoSizeColumn(5);
                sheetFirstCall.autoSizeColumn(6);

            }
            //Запись файла
            FileOutputStream fileOutPost = new FileOutputStream(filenamePost);
            workbookFirstCall.write(fileOutPost);
            fileOutPost.close();
            //Отправка на почту
            sendHtmlMessageKiaFirstCall(filenamePost);
            System.out.println("ПостСервисныйОбзвон создан!");
        }   catch ( Exception ex ) {
            System.out.println("Бяда!");
        }

        try {
            // Создают Excel файл
            String filenameNps = "C:/Users/User/Desktop/NPS-KIA Обзвон.xls";
            HSSFWorkbook workbookNPS = new HSSFWorkbook();
            HSSFSheet sheetNPS = workbookNPS.createSheet("NPS-KIA");

            //Шапка
            HSSFRow rowheadNPS = sheetNPS.createRow((short)0);
            rowheadNPS.createCell(0).setCellValue("No.");
            rowheadNPS.createCell(1).setCellValue("Номер ЗН");
            rowheadNPS.createCell(2).setCellValue("VIN");
            rowheadNPS.createCell(3).setCellValue("Телефон");
            rowheadNPS.createCell(4).setCellValue("ФИО");
            rowheadNPS.createCell(5).setCellValue("BQ010");
            rowheadNPS.createCell(6).setCellValue("BQ020");
            rowheadNPS.createCell(7).setCellValue("BQ030");
            rowheadNPS.createCell(8).setCellValue("BQ030 Прим.");
            rowheadNPS.createCell(9).setCellValue("BQ040");
            rowheadNPS.createCell(10).setCellValue("BQ050");
            rowheadNPS.createCell(11).setCellValue("BQ050 Прим.");
            rowheadNPS.createCell(12).setCellValue("BQ060");
            rowheadNPS.createCell(13).setCellValue("BQ070");
            rowheadNPS.createCell(14).setCellValue("BQ080");
            rowheadNPS.createCell(15).setCellValue("BQ080 Прим.");
            rowheadNPS.createCell(16).setCellValue("SQ020");
            rowheadNPS.createCell(17).setCellValue("SQ030");
            rowheadNPS.createCell(18).setCellValue("SQ040");
            rowheadNPS.createCell(19).setCellValue("SQ050");
            rowheadNPS.createCell(20).setCellValue("SQ060");
            rowheadNPS.createCell(21).setCellValue("SQ070");
            rowheadNPS.createCell(22).setCellValue("SQ080");
            rowheadNPS.createCell(23).setCellValue("SQ090");
            rowheadNPS.createCell(24).setCellValue("SQ110");
            rowheadNPS.createCell(25).setCellValue("SQ120");
            rowheadNPS.createCell(26).setCellValue("SQ130");
            rowheadNPS.createCell(27).setCellValue("SQ140");
            rowheadNPS.createCell(28).setCellValue("DQ010");
            rowheadNPS.createCell(29).setCellValue("DQ020");
            rowheadNPS.createCell(30).setCellValue("DQ030");
            rowheadNPS.createCell(31).setCellValue("DQ040");
            rowheadNPS.createCell(32).setCellValue("Дата звонка");

            for (int i=0; i< npsCall.size(); i++) {
                //Строки
                HSSFRow rowNPS = sheetNPS.createRow((short) i+1);
                rowNPS.createCell(0).setCellValue(i + 1);
                rowNPS.createCell(1).setCellValue(npsCall.get(i).getNum_order());
                rowNPS.createCell(2).setCellValue(npsCall.get(i).getVin());
                rowNPS.createCell(3).setCellValue(npsCall.get(i).getPhone());
                rowNPS.createCell(4).setCellValue(npsCall.get(i).getClient_name());
                sheetNPS.autoSizeColumn(0);
                sheetNPS.autoSizeColumn(1);
                sheetNPS.autoSizeColumn(2);
                sheetNPS.autoSizeColumn(3);
                sheetNPS.autoSizeColumn(4);

            }
            //Запись файла
            FileOutputStream fileOutNps = new FileOutputStream(filenameNps);
            workbookNPS.write(fileOutNps);
            fileOutNps.close();
            System.out.println("NPS-KIA создан!");
        }   catch ( Exception ex ) {
            System.out.println("Бяда!");
        }

    }

    private void sendHtmlMessageKiaFirstCall(String filenamePost) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("info@vitautocity.by");
        helper.setTo("k.shabanov@vitautocity.by");
        helper.setSubject("Пост сервисный обзвон клиентов KIA");
        helper.setText("""
                Добрый день!

                Прошу Вас провести обратную связь с клиентами и заполнить вложенный файл.
                После заполнения - отправить файл на электронную почту: k.shabanov@vitautocity.by""");


        FileSystemResource file1 = new FileSystemResource(new File(filenamePost));
        helper.addAttachment("C:/Users/User/Desktop/ПостСервисныйОбзвон.xls", file1);
        javaMailSender.send(message);


    }
}
