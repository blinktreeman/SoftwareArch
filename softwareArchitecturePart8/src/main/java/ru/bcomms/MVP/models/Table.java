package ru.bcomms.MVP.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {
    private static int counter;
    private final int no;

    private final Collection<Reservation> reservations = new ArrayList<>();


    {
        no = ++counter;
    }

    public int getNo() {
        return no;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public boolean removeReservation(int idToRemove) {
        Reservation reservation = reservations.stream()
                .filter(r -> r.getId() == idToRemove)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No reservation found"));
        return reservations.remove(reservation);
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}
