package com.dbc;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

    @Test
    public void newDate() {
        Calendar calendar = Calendar.getInstance(); //data atual
        // imutavel...

        System.out.println(calendar);
        Date time = calendar.getTime();
        System.out.println(time);

        System.out.println("Data/Hora atual: " + calendar.getTime());
        System.out.println("Ano: " + calendar.get(Calendar.YEAR));
        System.out.println("Ano: " + calendar.get(1));
        System.out.println("Mês: " + calendar.get(Calendar.MONTH) + 1); // 0=Janeiro, 1=Fevereiro
        System.out.println("Dia do Mês: " + calendar.get(Calendar.DAY_OF_MONTH));
    }

    //https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
    @Test
    public void manipularData() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1995);
        c.set(Calendar.MONTH, Calendar.MARCH);
//        c.set(Calendar.MONTH, 2);
        c.set(Calendar.DAY_OF_MONTH, 20);

        System.out.println("Data/Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
    }


    //https://mkyong.com/java/java-display-list-of-timezone-with-gmt/
    //https://docs.oracle.com/javase/7/docs/api/java/util/TimeZone.html
    @Test
    public void setarTimezone() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.setTimeZone(TimeZone.getTimeZone("Etc/GMT+12"));

        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTime());
    }

    @Test
    public void formatarCalendar() {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        //Formata a data
        DateFormat formataData = DateFormat.getDateInstance();
        System.out.println("Data atual com formatação: " + formataData.format(data));

        //Formata Hora
        DateFormat hora = DateFormat.getTimeInstance();
        System.out.println("Hora formatada: " + hora.format(data));

        //Formata Data e Hora
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        System.out.println(dtHora.format(data));
    }

    @Test
    public void converterParaCalendar() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar);
    }

    //https://www.oracle.com/java/technologies/javase/java8locales.html

    @Test
    public void locale() {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        Locale brasil = new Locale("pt", "BR"); //Retorna do país e a língua
        Locale eua = Locale.US;
        Locale italia = Locale.ITALIAN;

        DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println("Data e hora brasileira: " + f2.format(data));

        DateFormat f3 = DateFormat.getDateInstance(DateFormat.FULL, eua);
        System.out.println("Data e hora americana: " + f3.format(data));

        DateFormat f4 = DateFormat.getDateInstance(DateFormat.FULL, italia);
        System.out.println("Data e hora italiana: " + f4.format(data));
    }
}
