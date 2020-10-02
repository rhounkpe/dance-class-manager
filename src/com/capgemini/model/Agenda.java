package com.capgemini.model;


import java.util.HashSet;
import java.util.Set;

public class Agenda {
    private Set<DanceClass> eventList;

    public Agenda() {
        eventList = new HashSet<>();
    }

    public Set<DanceClass> getEventList() {
        return eventList;
    }

    public void addDanceClass(DanceClass danceClass) {
        eventList.add(danceClass);
    }
}
