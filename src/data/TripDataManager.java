package data;

import domain.Trip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TripDataManager {

    private static final String FILE_PATH = "trips.txt";
    private static final Logger LOGGER = Logger.getLogger(TripDataManager.class.getName());

    public static void saveTrips(List<Trip> trips) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(trips);
            LOGGER.info("Trips saved successfully to " + FILE_PATH);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error saving trips: " + e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Trip> loadTrips() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            LOGGER.warning("Trip file not found. Returning empty list.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            List<Trip> trips = (List<Trip>) ois.readObject();
            LOGGER.info("Trips loaded successfully from " + FILE_PATH);
            return trips;
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error loading trips: " + e.getMessage(), e);
            return new ArrayList<>();
        }
    }
}
