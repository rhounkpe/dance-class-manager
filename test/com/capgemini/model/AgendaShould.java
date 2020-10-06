package com.capgemini.model;

import com.capgemini.utils.DateTimeFormatter;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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


        danceClasses
                .stream()
                .map(ds -> {
                    if (Objects.nonNull(ds)) {
                        if(ds.getTime() != null) {
                            if (ds.getTime().equals(LocalTime.now())) {
                                ds.setTime(LocalTime.parse("11 25 2020"));
                            }
                        }
                    } else {
                        try {
                            throw new Exception("This element may not exist...");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return ds;

                }).collect(Collectors.toList());


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

        @Test
        @DisplayName("throw exception if entered pattern of string incorrect")
        void throwExceptionIfIncorrectDatePattern() {
            Throwable error = assertThrows(RuntimeException.class, () -> DateTimeFormatter.convertStringToLocaleDate("10 13 TT 2020"));

            // agenda.addDanceClass("Bachata Dominicaine", "denver", "10 13 TT 2020");
            String errorMsg = "Unable to create date from: [10 13 TT 2020], please enter a date with this format [MM dd yyyy]";
            assertEquals(errorMsg, error.getMessage());
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
