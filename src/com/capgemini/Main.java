package com.capgemini;

import com.capgemini.model.Agenda;
import com.capgemini.model.DanceClass;
import com.capgemini.model.Room;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Agenda agenda;

        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();

        agenda = new Agenda();

        DanceClass tango = new DanceClass("Cours de Tango", Room.BERLIN, LocalDate.now());
        agenda.addDanceClass("Cours de Tango", "BERLIN", "10 02 2020");
        agenda.addDanceClass("Cours de Salsa", "Tokyo", "10 03 2020");
        agenda.getEventList();


        for (DanceClass ds : agenda.getEventList()) {
            System.out.println(ds);
        }
    }
}
