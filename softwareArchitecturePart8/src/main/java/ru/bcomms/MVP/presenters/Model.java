package ru.bcomms.MVP.presenters;

import ru.bcomms.MVP.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     * @return номер бронирования
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Изменение резерва столика
     * @param oldReservation старый номер брони
     * @param reservationDate дата бронирования (новая)
     * @param tableNo номер столика
     * @param name имя
     * @return номер новой брони
     */
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
