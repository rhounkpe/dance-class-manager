package com.capgemini.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DanceClass extends DanceEvent {
    private LocalDate day;
    private LocalTime time;
    private Teacher teacher;

    public DanceClass(String name, Room room, LocalDate day) {
        super(name, room);
        this.day = day;
    }

    public DanceClass(String name, Room room, LocalDate day, LocalTime time) {
        this(name, room, day);
        this.time = time;
    }

    public DanceClass(String name, LocalDate day, LocalTime time, Room room, Teacher teacher) {
        this(name, room, day, time);
        this.teacher = teacher;
    }


    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return name + " le " + day;
    }

    // TODO: Override equals
    // TODO: Override hashCode
}
