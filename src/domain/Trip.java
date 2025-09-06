package domain;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String destination;
    private String startDate;
    private String endDate;
    private List<Note> notes;
    private List<Accommodation> accommodations;
    private Budget budget;

    public Trip(String destination, String startDate, String endDate) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = new ArrayList<>();
        this.accommodations = new ArrayList<>();
        this.budget = new Budget();
    }

    public String getDestination() {
        return destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    public Budget getBudget() {
        return budget;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void addAccommodation(Accommodation acc) {
        accommodations.add(acc);
    }

    @Override
    public String toString() {
        return "Trip to " + destination + " from " + startDate + " to " + endDate;
    }
}
