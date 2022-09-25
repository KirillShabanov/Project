package com.home.MyWorkTime.service;

import com.home.MyWorkTime.repository.ReportCallForVASRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;



@Slf4j
@Service
@NoArgsConstructor
public class ReportCallForVASService {

    private ReportCallForVASRepository reportCallForVASRepository;
    private JavaMailSender javaMailSender;

    @Autowired
    public ReportCallForVASService(ReportCallForVASRepository reportCallForVASRepository, JavaMailSender javaMailSender) {
        this.reportCallForVASRepository = reportCallForVASRepository;
        this.javaMailSender = javaMailSender;
    }

    @Scheduled(cron = "1 * 20 * * 7")
    public void npsKiaKomlev() throws MessagingException {
        String brand = "KIA";
        String name = "Илья Комлев";
        double criticForMonth = reportCallForVASRepository.getCriticForMonth(brand, name);
        double promoterForMonth = reportCallForVASRepository.getPromoterForMonth(brand, name);
        double resultNpsForMonth = ((promoterForMonth - criticForMonth) / (promoterForMonth + criticForMonth)) * 100;
        System.out.println(resultNpsForMonth + " -Месяц");

        double criticForWeek = reportCallForVASRepository.getCriticForWeek(brand, name);
        double promoterForWeek = reportCallForVASRepository.getPromoterForWeek(brand, name);
        double resultNpsForWeek = ((promoterForWeek - criticForWeek) / (promoterForWeek + criticForWeek)) * 100;
        System.out.println(resultNpsForWeek + " -Неделя");

        double criticMonthDepartment = reportCallForVASRepository.getCriticMonthDepartment(brand);
        double promoterForMonthDepartment = reportCallForVASRepository.getPromoterForMonthDepartment(brand);
        double resultForMonthDepartment = ((promoterForMonthDepartment - criticMonthDepartment) / (promoterForMonthDepartment + criticMonthDepartment)) * 100;
        System.out.println(resultForMonthDepartment + " -По отделу");

        String s = "i.komlev@vitautocity.by";
        sendHtmlMessageNps(s, name, resultNpsForMonth, resultNpsForWeek);
    }

   @Scheduled(cron = "2 * 20 * * 7")
    public void npsKiaTrutchenko() throws MessagingException {
        String brand = "KIA";
        String name = "Тимур Трутченко";
        double criticForMonth = reportCallForVASRepository.getCriticForMonth(brand, name);
        double promoterForMonth = reportCallForVASRepository.getPromoterForMonth(brand, name);
        double resultNpsForMonth = ((promoterForMonth - criticForMonth) / (promoterForMonth + criticForMonth)) * 100;
        System.out.println(resultNpsForMonth + " -Месяц");

        double criticForWeek = reportCallForVASRepository.getCriticForWeek(brand, name);
        double promoterForWeek = reportCallForVASRepository.getPromoterForWeek(brand, name);
        double resultNpsForWeek = ((promoterForWeek - criticForWeek) / (promoterForWeek + criticForWeek)) * 100;
        System.out.println(resultNpsForWeek + " -Неделя");


        double criticMonthDepartment = reportCallForVASRepository.getCriticMonthDepartment(brand);
        double promoterForMonthDepartment = reportCallForVASRepository.getPromoterForMonthDepartment(brand);
        double resultForMonthDepartment = ((promoterForMonthDepartment - criticMonthDepartment) / (promoterForMonthDepartment + criticMonthDepartment)) * 100;
        System.out.println(resultForMonthDepartment + " -По отделу");

        String s = "t.trutchenko@vitautocity.by";
        sendHtmlMessageNps(s, name, resultNpsForMonth, resultNpsForWeek);
    }

   @Scheduled(cron = "3 * 20 * * 7")
    public void npsBeliy() throws MessagingException {
        String name = "Игорь Белый";
        double criticForMonthMulti = reportCallForVASRepository.getCriticForMonthMulti(name);
        double promoterForMonthMulti = reportCallForVASRepository.getPromoterForMonthMulti(name);
        double resultNpsForMonthMulti = ((promoterForMonthMulti - criticForMonthMulti) / (promoterForMonthMulti + criticForMonthMulti)) * 100;
        System.out.println(resultNpsForMonthMulti + " -Месяц");

        double criticForWeekMulti = reportCallForVASRepository.getCriticForWeekMulti(name);
        double promoterForWeekMulti = reportCallForVASRepository.getPromoterForWeekMulti(name);
        double resultNpsForWeekMulti = ((promoterForWeekMulti - criticForWeekMulti) / (promoterForWeekMulti + criticForWeekMulti)) * 100;
        System.out.println(resultNpsForWeekMulti + " -Неделя");


        double criticMonthDepartmentMulti = reportCallForVASRepository.getCriticMonthDepartmentMulti();
        double promoterForMonthDepartmentMulti = reportCallForVASRepository.getPromoterForMonthDepartmentMulti();
        double resultForMonthDepartmentMulti = ((promoterForMonthDepartmentMulti - criticMonthDepartmentMulti) / (promoterForMonthDepartmentMulti + criticMonthDepartmentMulti)) * 100;
        System.out.println(resultForMonthDepartmentMulti + " -По отделу");

        String s = "i.belyi@vitautocity.by";
        sendHtmlMessageNps(s, name, resultNpsForMonthMulti, resultNpsForWeekMulti);
    }

    @Scheduled(cron = "4 * 20 * * 7")
    public void npsStolyarov() throws MessagingException {
        String name = "Андрей Столяров";
        double criticForMonthMulti = reportCallForVASRepository.getCriticForMonthMulti(name);
        double promoterForMonthMulti = reportCallForVASRepository.getPromoterForMonthMulti(name);
        double resultNpsForMonthMulti = ((promoterForMonthMulti - criticForMonthMulti) / (promoterForMonthMulti + criticForMonthMulti)) * 100;
        System.out.println(resultNpsForMonthMulti + " -Месяц");

        double criticForWeekMulti = reportCallForVASRepository.getCriticForWeekMulti(name);
        double promoterForWeekMulti = reportCallForVASRepository.getPromoterForWeekMulti(name);
        double resultNpsForWeekMulti = ((promoterForWeekMulti - criticForWeekMulti) / (promoterForWeekMulti + criticForWeekMulti)) * 100;
        System.out.println(resultNpsForWeekMulti + " -Неделя");


        double criticMonthDepartmentMulti = reportCallForVASRepository.getCriticMonthDepartmentMulti();
        double promoterForMonthDepartmentMulti = reportCallForVASRepository.getPromoterForMonthDepartmentMulti();
        double resultForMonthDepartmentMulti = ((promoterForMonthDepartmentMulti - criticMonthDepartmentMulti) / (promoterForMonthDepartmentMulti + criticMonthDepartmentMulti)) * 100;
        System.out.println(resultForMonthDepartmentMulti + " -По отделу");

        String s = "stoliarov@vitautocity.by";
        sendHtmlMessageNps(s, name, resultNpsForMonthMulti, resultNpsForWeekMulti);
    }

   @Scheduled(cron = "5 * 20 * * 7")
    public void npsTimofeev() throws MessagingException {
        String name = "Вадим Тимофеев";
        double criticForMonthMulti = reportCallForVASRepository.getCriticForMonthMulti(name);
        double promoterForMonthMulti = reportCallForVASRepository.getPromoterForMonthMulti(name);
        double resultNpsForMonthMulti = ((promoterForMonthMulti - criticForMonthMulti) / (promoterForMonthMulti + criticForMonthMulti)) * 100;
        System.out.println(resultNpsForMonthMulti + " -Месяц");

        double criticForWeekMulti = reportCallForVASRepository.getCriticForWeekMulti(name);
        double promoterForWeekMulti = reportCallForVASRepository.getPromoterForWeekMulti(name);
        double resultNpsForWeekMulti = ((promoterForWeekMulti - criticForWeekMulti) / (promoterForWeekMulti + criticForWeekMulti)) * 100;
        System.out.println(resultNpsForWeekMulti + " -Неделя");


        double criticMonthDepartmentMulti = reportCallForVASRepository.getCriticMonthDepartmentMulti();
        double promoterForMonthDepartmentMulti = reportCallForVASRepository.getPromoterForMonthDepartmentMulti();
        double resultForMonthDepartmentMulti = ((promoterForMonthDepartmentMulti - criticMonthDepartmentMulti) / (promoterForMonthDepartmentMulti + criticMonthDepartmentMulti)) * 100;
        System.out.println(resultForMonthDepartmentMulti + " -По отделу");

        String s = "timofeev@vitautocity.by";
        sendHtmlMessageNps(s, name, resultNpsForMonthMulti, resultNpsForWeekMulti);
    }

    @Scheduled(cron = "6 * 20 * * 7")
    public void npsZezekalo() throws MessagingException {
        String name = "Эрнест Зезекало";
        double criticForMonthGarantia = reportCallForVASRepository.getCriticForMonthGarantia(name);
        double promoterForMonthGarantia = reportCallForVASRepository.getPromoterForMonthGarantia(name);
        double resultNpsForMonthGarantia = ((promoterForMonthGarantia - criticForMonthGarantia) / (promoterForMonthGarantia + criticForMonthGarantia)) * 100;
        System.out.println(resultNpsForMonthGarantia + " -Месяц");

        double criticForWeekMultiGarantia = reportCallForVASRepository.getPromoterForWeekGarantia(name);
        double promoterForWeekMultiGarantia = reportCallForVASRepository.getCriticForWeekGarantia(name);
        double resultNpsForWeekMultiGarantia = ((promoterForWeekMultiGarantia - criticForWeekMultiGarantia) / (promoterForWeekMultiGarantia + criticForWeekMultiGarantia)) * 100;
        System.out.println(resultNpsForWeekMultiGarantia + " -Неделя");


        String s = "e.zezekalo@vitautocity.by";
        sendHtmlMessageNps(s, name, resultNpsForMonthGarantia, resultNpsForWeekMultiGarantia);
    }

    private void sendHtmlMessageNps(String s, String name,double resultNpsForMonth, double resultNpsForWeek) throws MessagingException {

        MimeMessage messageNps = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(messageNps, true, "UTF-8");
        helper.setFrom("info@vitautocity.by");
        helper.setTo(s); //-получатель
        helper.setCc("k.shabanov@vitautocity.by");  //-копия
        helper.setSubject("Результаты NPS, " + name);
        helper.setText("""
                Добрый день!

                Просим Вас ознакомиться с результатами по опросу NPS.
                Ваш результат за текущий месяц:\s """ +resultNpsForMonth +"%\n" +
               "Ваш результат за текущую неделю:\s " +resultNpsForWeek +"%");

        javaMailSender.send(messageNps);
    }

    @Scheduled(cron = "20 * 20 * * 7")
    public void npsManagement() throws MessagingException {
        String brand = "KIA";
        String name = "Илья Комлев";
        double criticForWeek = reportCallForVASRepository.getCriticForWeek(brand, name);
        double promoterForWeek = reportCallForVASRepository.getPromoterForWeek(brand, name);
        double resultNpsForWeekKomlev = ((promoterForWeek - criticForWeek) / (promoterForWeek + criticForWeek)) * 100;
        brand = "KIA";
        name = "Тимур Трутченко";
        criticForWeek = reportCallForVASRepository.getCriticForWeek(brand, name);
        promoterForWeek = reportCallForVASRepository.getPromoterForWeek(brand, name);
        double resultNpsForWeekTrutcenko = ((promoterForWeek - criticForWeek) / (promoterForWeek + criticForWeek)) * 100;
        name = "Игорь Белый";
        double criticForWeekMulti = reportCallForVASRepository.getCriticForWeekMulti(name);
        double promoterForWeekMulti = reportCallForVASRepository.getPromoterForWeekMulti(name);
        double resultNpsForWeekMultiBeliy = ((promoterForWeekMulti - criticForWeekMulti) / (promoterForWeekMulti + criticForWeekMulti)) * 100;
        name = "Андрей Столяров";
        criticForWeekMulti = reportCallForVASRepository.getCriticForWeekMulti(name);
        promoterForWeekMulti = reportCallForVASRepository.getPromoterForWeekMulti(name);
        double resultNpsForWeekMultiStolyarov = ((promoterForWeekMulti - criticForWeekMulti) / (promoterForWeekMulti + criticForWeekMulti)) * 100;
        name = "Вадим Тимофеев";
        criticForWeekMulti = reportCallForVASRepository.getCriticForWeekMulti(name);
        promoterForWeekMulti = reportCallForVASRepository.getPromoterForWeekMulti(name);
        double resultNpsForWeekMultiTemofeev= ((promoterForWeekMulti - criticForWeekMulti) / (promoterForWeekMulti + criticForWeekMulti)) * 100;
        name = "Эрнест Зезекало";
        double criticForWeekMultiGarantia = reportCallForVASRepository.getPromoterForWeekGarantia(name);
        double promoterForWeekMultiGarantia = reportCallForVASRepository.getCriticForWeekGarantia(name);
        double resultNpsForWeekMultiGarantia = ((promoterForWeekMultiGarantia - criticForWeekMultiGarantia) / (promoterForWeekMultiGarantia + criticForWeekMultiGarantia)) * 100;

        double criticForMonthAll = reportCallForVASRepository.getCriticForMonthAll();
        double promoterForMonthAll = reportCallForVASRepository.getPromoterForMonthAll();
        double resultNpsForMonthAll = ((promoterForMonthAll - criticForMonthAll) / (promoterForMonthAll + criticForMonthAll)) * 100;


        sendHtmlMessageNpsManagement(resultNpsForWeekKomlev, resultNpsForWeekTrutcenko,
                resultNpsForWeekMultiBeliy, resultNpsForWeekMultiStolyarov,
                resultNpsForWeekMultiTemofeev, resultNpsForMonthAll, resultNpsForWeekMultiGarantia);
    }

    private void sendHtmlMessageNpsManagement(double resultNpsForWeekKomlev,
                                              double resultNpsForWeekTrutcenko, double resultNpsForWeekMultiBeliy,
                                              double resultNpsForWeekMultiStolyarov, double resultNpsForWeekMultiTemofeev,
                                              double resultNpsForMonthAll, double resultNpsForWeekMultiGarantia) throws MessagingException {

        MimeMessage messageNpsManagement = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(messageNpsManagement, true, "UTF-8");
        helper.setFrom("info@vitautocity.by");
        helper.setTo("nikolaevsky@vitautocity.by"); //-получатель nikolaevsky@vitautocity.by
        helper.setCc("k.shabanov@vitautocity.by");  //-копия
        helper.setCc("p.dashchonak@vitautocity.by");  //-копия
        helper.setCc("kukishev@vitautocity.by");  //-копия
        helper.setCc("j.borodulina@vitautocity.by");  //-копия
        helper.setSubject("Результаты NPS");
        helper.setText("""
                Добрый день!

                Просим Вас ознакомиться с результатами по показателю NPS.
                Общий показатель NPS за текущий месяц:\s """ +resultNpsForMonthAll +"%\n" +
                "Показатели NPS за текущую неделю по сотрудникам." + "%\n" +
                "Комлев Илья Юрьевич:\s " +resultNpsForWeekKomlev +"%" + "%\n" +
                "Трутченко Тимур Валентинович:\s " +resultNpsForWeekTrutcenko +"%" + "%\n" +
                "Белый Игорь Игоревич:\s " +resultNpsForWeekMultiBeliy +"%" + "%\n" +
                "Столяров Андрей Олегович:\s " +resultNpsForWeekMultiStolyarov +"%" + "%\n" +
                "Тимофеев Вадим Александрович:\s " +resultNpsForWeekMultiTemofeev +"%" + "%\n" +
                "Зезекало Эрнест Андреевич:\s " +resultNpsForWeekMultiGarantia +"%");

        javaMailSender.send(messageNpsManagement);
    }
}
