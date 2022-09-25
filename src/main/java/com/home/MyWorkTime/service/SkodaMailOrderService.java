package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.KiaMailOrderModel;
import com.home.MyWorkTime.entity.SkodaMailOrderModel;
import com.home.MyWorkTime.repository.KiaMailOrderRepository;
import com.home.MyWorkTime.repository.SkodaMailOrderRepository;
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
public class SkodaMailOrderService {

    private final SkodaMailOrderRepository skodaMailOrderRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public SkodaMailOrderService(SkodaMailOrderRepository skodaMailOrderRepository, JavaMailSender javaMailSender) {
        this.skodaMailOrderRepository = skodaMailOrderRepository;
        this.javaMailSender = javaMailSender;
    }

    @Scheduled(cron = "2 * 20 * * *")
    public void createExcelSkodaCall() {
        List<SkodaMailOrderModel> firstCall = skodaMailOrderRepository.getFirstCall();

        try {
            // Создают Excel файл
            String filenamePost = "C:/Users/User/Desktop/MyWorkTime/MyWorkTime/src/main/resources/exportData/feedBack/firstCallSkoda.xls";
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
            sendHtmlMessageSkodaFirstCall(filenamePost);
        }   catch ( Exception ex ) {
            System.out.println("Бяда!");
        }



    }
    @Scheduled(cron = "1 * 20 * * *")
    public void createExcelNPSSkodaCall(){
        List<SkodaMailOrderModel> npsCall = skodaMailOrderRepository.getNPSCall();

        try {
            // Создают Excel файл
            String filenameNps = "C:/Users/User/Desktop/MyWorkTime/MyWorkTime/src/main/resources/exportData/feedBack/NPSskoda.xls";
            HSSFWorkbook workbookNPS = new HSSFWorkbook();
            HSSFSheet sheetNPS = workbookNPS.createSheet("NPS-Skoda");

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
            sendHtmlMessageSkodaNpsCall(filenameNps);
        }   catch ( Exception ex ) {
            System.out.println("NPS Skoda не создан!");
        }
    }

    private void sendHtmlMessageSkodaFirstCall(String filenamePost) throws MessagingException {

        MimeMessage messageFirstCall = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(messageFirstCall, true, "UTF-8");
        helper.setFrom("info@vitautocity.by");
        helper.setTo("i.belyi@vitautocity.by");  //-получатель
        helper.setTo("stoliarov@vitautocity.by");  //-копия
        helper.setTo("timofeev@vitautocity.by");  //-копия
        helper.setCc("k.shabanov@vitautocity.by");  //-копия
        helper.setSubject("Пост сервисный обзвон клиентов Skoda");
        helper.setText("""
                Добрый день!

                Прошу Вас провести обратную связь с клиентами и заполнить вложенный файл.
                После заполнения - отправить файл на электронную почту: k.shabanov@vitautocity.by""");


        FileSystemResource fileFirstCall = new FileSystemResource(new File(filenamePost));
        helper.addAttachment("firstCallKia.xls", fileFirstCall);
        javaMailSender.send(messageFirstCall);
    }

    private void sendHtmlMessageSkodaNpsCall(String filenameNps) throws MessagingException {

        MimeMessage messageNpsCall = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(messageNpsCall, true, "UTF-8");
        helper.setFrom("info@vitautocity.by");
        helper.setTo("administator@vitautocity.by"); //-получатель
        helper.setCc("k.shabanov@vitautocity.by");  //-копия
        helper.setSubject("NPS Skoda");
        helper.setText("""
                Добрый день!

                Прошу Вас провести обратную связь с клиентами и заполнить вложенный файл.
                Прошу учесть, что один клиент из представленного списка должен быть опрошен по расширенному чек-листу.
                После заполнения - отправить файл на электронную почту: k.shabanov@vitautocity.by""");


        FileSystemResource fileNpsCall = new FileSystemResource(new File(filenameNps));
        helper.addAttachment("NPSskoda.xls", fileNpsCall);
        javaMailSender.send(messageNpsCall);
    }
}
