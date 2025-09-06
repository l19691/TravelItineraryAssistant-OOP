import domain.Trip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TripTest {

    @Test
    public void testTripCreation() {
        Trip trip = new Trip("Paris", "2025-09-06", "2025-09-10");
        assertEquals("Paris", trip.getDestination());
        assertEquals("2025-09-06", trip.getStartDate());
        assertEquals("2025-09-10", trip.getEndDate());
        assertTrue(trip.getNotes().isEmpty());
        assertTrue(trip.getAccommodations().isEmpty());
    }
}
