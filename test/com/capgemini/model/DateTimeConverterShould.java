package com.capgemini.model;

import com.capgemini.utils.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@DisplayName("Date time converter should")
public class DateTimeConverterShould {
    @Test
    @DisplayName("convert string to LocaleDate")
    void convertStringToLocaleDate() {
        // Agenda agenda = new Agenda();
        String date = "10 13 2020";
        LocalDate localDate = DateTimeFormatter.convertStringToLocaleDate(date);

        //agenda.addDanceClass("Tango Argentin", "Tokyo", date);
        // assertEquals(localDate, );
    }
}
