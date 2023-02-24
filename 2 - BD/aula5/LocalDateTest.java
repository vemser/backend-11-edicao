package com.dbc;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class LocalDateTest {

    /**
     * LOCALDATE
     */
    // a date in ISO format (yyyy-MM-dd) without time.
    @Test
    public void localDateTest() {
        LocalDate now = LocalDate.now();

        System.out.println(now);
        System.out.println(LocalDate.of(2015, 02, 20));
        System.out.println(LocalDate.parse("2015-02-20"));
    }

    @Test
    public void manipulandoLocalDate() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        tomorrow = tomorrow.plusDays(10);
        System.out.println(tomorrow);

        tomorrow.plus(100, ChronoUnit.DECADES);

        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println(previousMonthSameDay);
    }

    @Test
    public void pegandoVariaveisLocalDate() {
        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
        boolean leapYear = LocalDate.now().isLeapYear(); // bissexto
    }

    @Test
    public void compararLocalDates() {
        boolean notBefore = LocalDate.parse("2016-06-12")
                .isBefore(LocalDate.parse("2016-06-11"));

        boolean isAfter = LocalDate.parse("2016-06-12")
                .isAfter(LocalDate.parse("2016-06-11"));
    }

    @Test
    public void ajustarData() {
        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
        System.out.println(beginningOfDay);
        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
                .with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);
    }


    /**
     * LOCALTIME
     */

    @Test
    public void inicializarLocalTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime sixThirty = LocalTime.parse("06:30:00");
        LocalTime sixThirty2 = LocalTime.of(6, 30);
    }

    @Test
    public void manipularLocalTime() {
        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
        int six = LocalTime.parse("06:30").getHour();
        LocalTime maxTime = LocalTime.MAX;
    }

    @Test
    public void compararLocalTime() {
        boolean isBefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
        boolean isAfter = LocalTime.parse("06:30").isAfter(LocalTime.parse("07:30"));
    }


    /**
     * LOCALDATETIME
     */
    @Test
    public void inicializarLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
        LocalDateTime.parse("2015-02-20T06:30:00");
    }

    @Test
    public void manipularLocalDateTIme() {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.plusDays(1);
        localDateTime = localDateTime.minusHours(2);

        long minutes = ChronoUnit.MINUTES.between(localDateTime, LocalDateTime.now());
        System.out.println(minutes);

        localDateTime.getMonth();
    }

    @Test
    public void zones() {
        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);

        ZoneId zoneId = ZoneId.of("Europe/Paris");

        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);

        ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");

        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
    }

    @Test
    public void period() {
        LocalDate initialDate = LocalDate.parse("2007-05-10");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        Period between = Period.between(initialDate, finalDate);
        int five = between.getDays();
        long five2 = ChronoUnit.DAYS.between(initialDate, finalDate);
    }

    public void duration() {
        LocalTime initialTime = LocalTime.of(6, 30, 0);

        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        long thirty = Duration.between(initialTime, finalTime).getSeconds();

        long thirty2 = ChronoUnit.SECONDS.between(initialTime, finalTime);
    }

    @Test
    public void format() {
        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
        String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        System.out.println(localDateTime
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                        .withLocale(Locale.UK)));
    }

    @Test
    public void convert() {
        // LocalDate -> LocalDateTime
        LocalDate data = LocalDate.of(2018, Month.SEPTEMBER, 17);
        LocalDateTime dt = data.atTime(10, 30);

        // LocalDateTime -> LocalDate
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);


    }

    // https://www.baeldung.com/java-8-date-time-intro


    // converter localdate localdatetime localtime

}
