package com.capgemini.model;

import org.junit.jupiter.api.*;

import java.time.format.DateTimeFormatter;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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
        agenda.addDanceClass("Salsa", "denver", "10 24 2020");
    }

    @Test
    void addDanceClass() {
        System.out.println("Test case 1");
        Set<DanceClass> danceClasses = agenda.getEventList();

        assertNotNull(danceClasses);

        assertEquals(2, danceClasses.size());

    }

    @Test
    void wellFormedDate() {
        System.out.println("Test case 2");
        Set<DanceClass> danceClasses = agenda.getEventList();
        DanceClass tango = (DanceClass) danceClasses.toArray()[0];
        // assertEquals("10 13 2020", tango.getDay().format(DateTimeFormatter.ofPattern("MM dd yyyy")));
        // assertSame(Room.TOKYO, tango.getRoom());
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
