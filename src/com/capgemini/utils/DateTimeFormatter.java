package com.capgemini.utils;

import java.time.LocalDate;
import java.util.Locale;

public class DateTimeFormatter {
    public static LocalDate convertStringToLocaleDate(String date) {
        LocalDate localDate;
        Locale fr = Locale.FRANCE;
        try {
            localDate = LocalDate.parse(date, java.time.format.DateTimeFormatter.ofPattern("MM dd yyyy", fr));
        } catch (Throwable t) {
            throw new RuntimeException("Unable to create date from: [" +
                    date.toUpperCase() +
                    "], please enter a date with this format [MM dd yyyy]");
        }

        return localDate;
    }
}
