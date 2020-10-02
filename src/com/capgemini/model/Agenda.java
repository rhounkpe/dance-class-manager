package com.capgemini.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Agenda {
    /**
     * A List is an ordered group of values that are indexed numerically
     *
     * A Set is a group of unique values without an index
     */
    private Set<DanceClass> eventList;

    public Agenda() {
        eventList = new HashSet<>();
    }

    public void addDanceClass(String name, String roomKey, String day) {
        LocalDate localDate;
        DanceClass danceClass;
        Room room = Room.valueOf(roomKey.toUpperCase());
        Locale fr = Locale.FRANCE;

        try {
            localDate = LocalDate.parse(day, DateTimeFormatter.ofPattern("MM dd yyyy", fr));
        } catch (Throwable t) {
            throw new RuntimeException("Unable to create date from: [" +
                    day.toUpperCase() +
            "], please enter a date with this format [MM dd yyyy]");
        }

        danceClass = new DanceClass(name, room, localDate);
        eventList.add(danceClass);

    }

    public Set<DanceClass> getEventList() {
        return eventList;
    }
}
