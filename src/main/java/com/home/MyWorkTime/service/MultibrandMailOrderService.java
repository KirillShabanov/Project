package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.MultibrandMailOrderModel;
import com.home.MyWorkTime.repository.MultibrandMailOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


@Slf4j
@Service
public class MultibrandMailOrderService {

    private final MultibrandMailOrderRepository multibrandMailOrderRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public MultibrandMailOrderService(MultibrandMailOrderRepository multibrandMailOrderRepository, JavaMailSender javaMailSender) {
        this.multibrandMailOrderRepository = multibrandMailOrderRepository;
        this.javaMailSender = javaMailSender;
    }

    @Scheduled(cron = "1 50 16 * * *")
    public void createExcelMultibrandCall() {
        List<MultibrandMailOrderModel> firstCall = multibrandMailOrderRepository.getFirstCall();

        try {
            // Создают Excel файл
            String filenamePost = "C:/Users/User/IdeaProjects/Project/src/main/resources/exportData/feedBack/firstCallMultibrand.xls";
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
            rowheadFirstCall.createCell(7).setCellValue("Дата звонка");


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
            sendHtmlMessageMultibrandFirstCall(filenamePost);
        }   catch ( Exception ex ) {
            System.out.println("Первый звонок Multibrand не создан!");
        }



    }
    @Scheduled(cron = "1 50 16 * * *")
    public void createExcelNPSMultibrandCall(){
        List<MultibrandMailOrderModel> npsCall = multibrandMailOrderRepository.getNPSCall();

        try {
            // Создают Excel файл
            String filenameNps = "C:/Users/User/IdeaProjects/Project/src/main/resources/exportData/feedBack/NPSmultibrand.xls";
            HSSFWorkbook workbookNPS = new HSSFWorkbook();
            HSSFSheet sheetNPS = workbookNPS.createSheet("NPS-Multibrand");

            //Шапка
            HSSFRow rowheadNPS = sheetNPS.createRow((short)0);
            rowheadNPS.createCell(0).setCellValue("No.");
            rowheadNPS.createCell(1).setCellValue("Номер ЗН");
            rowheadNPS.createCell(2).setCellValue("VIN");
            rowheadNPS.createCell(3).setCellValue("Телефон");
            rowheadNPS.createCell(4).setCellValue("ФИО");
            rowheadNPS.createCell(5).setCellValue("BQ010");

            rowheadNPS.createCell(6).setCellValue("Дата звонка");
            rowheadNPS.createCell(7).setCellValue("ИФ Администратора");

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
                sheetNPS.autoSizeColumn(7);

            }
            //Запись файла
            FileOutputStream fileOutNps = new FileOutputStream(filenameNps);
            workbookNPS.write(fileOutNps);
            fileOutNps.close();
            sendHtmlMessageMultibrandNpsCall(filenameNps);
        }   catch ( Exception ex ) {
            System.out.println("NPS Multibrand не создан!");
        }
    }

    private void sendHtmlMessageMultibrandFirstCall(String filenamePost) throws MessagingException {

        MimeMessage messageFirstCall = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(messageFirstCall, true, "UTF-8");
        helper.setFrom("info@vitautocity.by");
        helper.setTo("i.beluy@vitautocity.by");  //-получатель
        helper.setTo("stoliarov@vitautocity.by");  //-получатель
        helper.setTo("timofeev@vitautocity.by");  //-получатель
        helper.setCc("k.shabanov@vitautocity.by");  //-копия
        helper.setSubject("Пост сервисный обзвон клиентов Multibrand");
        helper.setText("""
                Добрый день!

                Прошу Вас провести обратную связь с клиентами и заполнить вложенный файл.
                После заполнения - отправить файл на электронную почту: k.shabanov@vitautocity.by""");


        FileSystemResource fileFirstCall = new FileSystemResource(new File(filenamePost));
        helper.addAttachment("firstCallMultibrand.xls", fileFirstCall);
        javaMailSender.send(messageFirstCall);
    }

    private void sendHtmlMessageMultibrandNpsCall(String filenameNps) throws MessagingException {

        MimeMessage messageNpsCall = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(messageNpsCall, true, "UTF-8");
        helper.setFrom("info@vitautocity.by");
        helper.setTo("administrator@vitautocity.by"); //-получатель
        helper.setCc("k.shabanov@vitautocity.by");  //-копия
        helper.setSubject("NPS Multibrand");
        helper.setText("""
                Добрый день!

                Прошу Вас провести обратную связь с клиентами и заполнить вложенный файл.
                После заполнения - отправить файл на электронную почту: k.shabanov@vitautocity.by""");


        FileSystemResource fileNpsCall = new FileSystemResource(new File(filenameNps));
        helper.addAttachment("NPSmultibrand.xls", fileNpsCall);
        javaMailSender.send(messageNpsCall);
    }
}
