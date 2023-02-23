package com.dbc;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class DateTest {

    // https://programminghints.com/2017/05/still-using-java-util-date-dont/
    @Test
    public void testarNewDate() {
        Date date = new Date(); // cria uma data e instancia com a data atual...
        System.out.println(date);
        System.out.println(date.getTime());
        assertNotNull(date);
        Date date0 = new Date(0);
        System.out.println(date0);

//        date.setYear(); //deprecado..
    }

    @Test
    public void testarSetTime() {
        Date date = new Date(1667849458254L);
        System.out.println(date);//Wed Dec 31 21:00:00 GMT-03:00 1969 (timezone...)
    }


    @Test
    public void comparacao() {
        Date d1 = new Date(2000, 11, 21);
        Date d2 = new Date(2023, 2, 23);  // Current date
        Date d3 = new Date(2010, 1, 3);
        boolean a = d3.after(d1); // 2010 está depois de 2000?
        System.out.println("Date d3 comes after " +
                "date d2: " + a);

        boolean b = d3.before(d2); // 2010 está antes de 2023?
        System.out.println("Date d3 comes before " +
                "date d2: " + b);

        // < 0 = menor
        // = 0 = igual
        // > 0 = maior
        int c = d1.compareTo(d2); ///2000 2023
        System.out.println(c);

    }

    // https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
    @Test
    public void formatarData() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String minhaDataStr = "10/09/2023";

        try {
            Date minhaData = formato.parse(minhaDataStr);
            System.out.println(minhaData);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date data = new Date();

        String dataStr = formato.format(data);
        System.out.println(dataStr);
    }
}
