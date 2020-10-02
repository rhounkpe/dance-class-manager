package com.capgemini;

import com.capgemini.model.Agenda;
import com.capgemini.model.DanceClass;

import java.util.Scanner;

public class Main {
    private static Agenda agenda;

    public static void main(String[] args) throws Throwable {
        agenda = new Agenda();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nWelcome to our Agenda!\n");

        String option = "";

        while (!option.equalsIgnoreCase("x")) {
            option = displayMenu(sc);
        }

        System.out.println("\nExiting System...\n");
    }

    private static String displayMenu(Scanner sc) throws Throwable {
        System.out.println("Please select an option: ");
        System.out.println("\t1. Enter a Dance Class");
        System.out.println("\t2. Display Dance Classes");
        System.out.println("\tX. Exit System");

        String option = sc.next();

        switch (option) {
            case "1": encodeDanceClass(sc);
                return option;
            case "2": displayDanceClasses();
                return option;
            default:
                System.out.println("Invalid option, please re-enter your choice!");
                return option;
        }
    }

    /**
     * Encode new Dance Class
     * @param sc
     */
    private static void encodeDanceClass(Scanner sc) {
        System.out.println("Please enter Dance Class info");
        sc.nextLine();
        System.out.println("Dance Class name: ");
        String name = sc.nextLine();

        System.out.println("Where?: ");
        String roomKey = sc.nextLine();

        System.out.println("When? (MM dd yyyy): ");
        String date = sc.nextLine();

        try {
            agenda.addDanceClass(name, roomKey, date);
        } catch (Throwable t) {
            System.out.println("Error! " + t.getMessage());
            return;
        }

    }

    private static void displayDanceClasses() throws Throwable {
        System.out.println("All Dance Classes");

        for (DanceClass danceClass : agenda.getEventList()) {
            System.out.println(danceClass);
        }

        System.out.println("\nPress any key to continue...");
        System.in.read();
        System.out.println("\n");
    }

}
