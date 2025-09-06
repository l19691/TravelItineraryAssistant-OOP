package app;

import domain.*;
import data.TripDataManager;
import util.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static List<Trip> trips = new ArrayList<>();

    public static void main(String[] args) {
        trips = TripDataManager.loadTrips();
        System.out.println("Welcome to the Travel Itinerary Assistant!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Add Trip\n2. View Trips\n3. Save & Exit");
            int choice = InputHelper.getInt("Choose");

            switch (choice) {
                case 1 -> addTrip();
                case 2 -> viewTrips();
                case 3 -> {
                    TripDataManager.saveTrips(trips);
                    exit = true;
                    System.out.println("Saved. Goodbye!");
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addTrip() {
        String dest = InputHelper.getString("Destination");
        String start = InputHelper.getString("Start Date (YYYY-MM-DD)");
        String end = InputHelper.getString("End Date (YYYY-MM-DD)");
        Trip trip = new Trip(dest, start, end);

        boolean done = false;
        while (!done) {
            System.out.println("\n1. Add Note\n2. Add Accommodation\n3. Set Budget\n4. Done");
            int choice = InputHelper.getInt("Choose");

            switch (choice) {
                case 1 -> {
                    String noteContent = InputHelper.getString("Note content");
                    String date = InputHelper.getString("Date (YYYY-MM-DD)");
                    trip.addNote(new Note(noteContent, date));
                }
                case 2 -> {
                    String name = InputHelper.getString("Accommodation name");
                    String addr = InputHelper.getString("Address");
                    double cost = InputHelper.getDouble("Cost");
                    trip.addAccommodation(new Accommodation(name, addr, cost));
                    trip.getBudget().addSpent(cost);
                }
                case 3 -> {
                    double limit = InputHelper.getDouble("Set total budget");
                    trip.getBudget().setLimit(limit);
                }
                case 4 -> done = true;
                default -> System.out.println("Invalid option.");
            }
        }

        trips.add(trip);
        System.out.println("Trip added!");
    }

    private static void viewTrips() {
        if (trips.isEmpty()) {
            System.out.println("No trips found.");
            return;
        }

        for (int i = 0; i < trips.size(); i++) {
            Trip t = trips.get(i);
            System.out.println("\n[" + (i + 1) + "] " + t);
            System.out.println("  Budget: " + t.getBudget());

            if (!t.getNotes().isEmpty()) {
                System.out.println("  Notes:");
                t.getNotes().forEach(n -> System.out.println("    " + n));
            }

            if (!t.getAccommodations().isEmpty()) {
                System.out.println("  Accommodations:");
                t.getAccommodations().forEach(a -> System.out.println("    " + a));
            }
        }
    }
}
