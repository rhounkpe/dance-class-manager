package com.capgemini.model;

public enum Room {
    TOKYO("Salle Tokyo"),
    NAIROBI("Salle Nairobi"),
    BERLIN("Salle Berlin"),
    DENVER("Salle Denver"),
    RIO("Salle Rio"),
    HELSINKI("Salle Helsinki"),
    OSLO("Salle Oslo"),
    MOSCOW("Salle Moscow");

    private String name;

    Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
