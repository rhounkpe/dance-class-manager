package com.capgemini.model;


import java.time.LocalDate;
import java.util.HashSet;
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
        DanceClass danceClass;
        Room room = Room.valueOf(roomKey.toUpperCase());
        LocalDate localDate = com.capgemini.utils.DateTimeFormatter.convertStringToLocaleDate(day);

        danceClass = new DanceClass(name, room, localDate);
        eventList.add(danceClass);

    }

    public Set<DanceClass> getEventList() {
        return eventList;
    }
}
