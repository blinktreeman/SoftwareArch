package ru.bcomms.MVP.models;

import ru.bcomms.MVP.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class BookingModel implements Model {

    private Collection<Table> tables;

    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            имя
     * @return номер бронирования
     */
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        Optional<Table> table = loadTables().stream().filter(t -> t.getNo() == tableNo).findFirst();
        if (table.isPresent()) {
            Reservation reservation = new Reservation(reservationDate, name);
            table.get().getReservations().add(reservation);
            return reservation.getId();
        }
        throw new RuntimeException("Некорректный номер столика.");
    }

    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        Table tableToRemoveReservation = null;
        for (Table table : tables) {
            Optional<Reservation> reservation = table.getReservations()
                    .stream()
                    .filter(r -> r.getId() == oldReservation)
                    .findFirst();
            // Стол с нужным номером брони
            if (reservation.isPresent()) {
                tableToRemoveReservation = table;
            }
        }
        // При успешном удалении брони, выполнить новую
        if (tableToRemoveReservation != null && tableToRemoveReservation.removeReservation(oldReservation)) {
            return this.reservationTable(reservationDate, tableNo, name);
        }
        else throw new RuntimeException("Booking error");
    }
}
