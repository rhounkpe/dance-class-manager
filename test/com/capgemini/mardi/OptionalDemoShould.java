package com.capgemini.mardi;

import com.capgemini.model.DanceClass;
import com.capgemini.model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Optional Demo should")
class OptionalDemoShould {
    private Optional<Double> average1;
    private Optional<Double> average2;

    @BeforeEach
    void setUp() {
        average1 = OptionalDemo.average(90, 100);
        average2 = OptionalDemo.average();
    }

    @Test
    @DisplayName("compute the average of a list of empty value")
    void computeTheAverageOfAListOfEmptyValue() {
        assertEquals(Optional.empty(), average2);
        // java.util.NoSuchElementException: No value present
        // assertEquals(Optional.empty(), average.get());
    }

    @Test
    @DisplayName("compute the average of a list of value")
    void computeTheAverageOfAListOfValue() {
        if (average1.isPresent()) {
            assertEquals(95.0, average1.get());
        }
    }

    @Test
    @DisplayName("throw no such element exception if get on empty optional")
    void throwNoSuchElementExceptionIfGetOnEmptyOptional() {
        Exception error = assertThrows(RuntimeException.class, () -> average2.get());
        assertEquals("No value present", error.getMessage());
    }

    @Test
    void avoidNullPointerException() {
        DanceClass danceClass = new DanceClass("Cours de Lindy Hop", Room.HELSINKI, LocalDate.of(2020, 10, 30));
        danceClass.setTime(LocalTime.of(18, 30));

        Optional timeOptional = Objects.isNull(danceClass.getTime()) ? Optional.empty() : Optional.of(danceClass.getTime());

        if (timeOptional.isPresent()){
            // Do something
            danceClass.setTime(danceClass.getTime().plusHours(1));
        } else {
            // Do something elese...
            // Set it to current time
            danceClass.setTime(LocalTime.now());
            assertTrue(LocalTime.parse("19:30").equals(danceClass.getTime()));
            assertTrue(LocalTime.parse("10:00", DateTimeFormatter.ISO_DATE).isBefore(danceClass.getTime()));
        }
    }

    /**
     * Dans le cas de test précédent, nous avons vérifier que l'heure du cours existe bel et bien.
     * Si l'heure n'existe pas, nous renvoyons un Optional.empty()
     * Sinon nous renvoyons un Optional construit avec Optional.of(danceClass.getTime())
     *
     * Ce pattern est si courant que Java fournie une "factory method" pour faire la même chose.
     * Utilisez Optional.Nullable(danceClass) pour faire la même chose (Google, StackOverFlow, Java Doc... sont vos amis)
     */
    @Test
    void useFactoryMethodOfNullable() {
        DanceClass danceClass = new DanceClass("Cours de Lindy Hop", Room.HELSINKI, LocalDate.of(2020, 10, 30));


        // Créez l'optional ici
        Optional timeOptional = .....

        // L'heure du cours sera désormais à l'heure courante de la Zone HELSINKI
        // Indice UTC
        // Créez une heure au time zone de Paris et comparer si l'heure du cours est la même que l'heure de Paris
        // Créer une une heure au time zone de Brussels et comparer avec l'heure de Paris


    }
}
