package com.capgemini.model;

import com.capgemini.utils.DateTimeFormatter;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Agenda should")
class AgendaShould {

    private Agenda agenda;

    @BeforeAll
    static void initAll() {
        System.out.println("Launching tests....");
    }

    @BeforeEach
    void init() {
        System.out.println("Before each");
        agenda = new Agenda();
        agenda.addDanceClass("Tango Argentin", "Tokyo", "10 13 2020");
        // agenda.addDanceClass("Salsa", "denver", "10 24 2020");
    }

    @Test
    @DisplayName("add dance class")
    void addDanceClass() {
        System.out.println("Test case 1");
        Set<DanceClass> danceClasses = agenda.getEventList();

        assertNotNull(danceClasses);

        assertEquals(1, danceClasses.size());

    }

    @Nested
    @DisplayName("format string to date")
    class FormatStringToDate {

        @Test
        @DisplayName("convert string to LocaleDate")
        void convertStringToLocaleDate() {
            LocalDate localDate = DateTimeFormatter.convertStringToLocaleDate("10 13 2020");
            assertEquals(localDate, LocalDate.parse("10 13 2020", java.time.format.DateTimeFormatter.ofPattern(
                    "MM dd yyyy", Locale.FRANCE
            )));
        }

        @Test
        @Disabled
        @DisplayName("well form date")
        void wellFormedDate() {
            System.out.println("Test case 2");
            Set<DanceClass> danceClasses = agenda.getEventList();
            DanceClass tango = (DanceClass) danceClasses.toArray()[0];
            // assertEquals("10 13 2020", tango.getDay().format(DateTimeFormatter.ofPattern("MM dd yyyy", )));
            assertSame(Room.DENVER, tango.getRoom());
        }
    }



    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Finish testing...");
    }
}
