package ru.bcomms;

import ru.bcomms.MVP.models.BookingModel;
import ru.bcomms.MVP.presenters.BookingPresenter;
import ru.bcomms.MVP.views.BookingView;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        BookingModel bookingModel = new BookingModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(bookingModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        bookingView.reservationTable(new Date(), 3, "Евгений");

        bookingView.changeReservationTable(1, new Date(), 5, "Евгений");
    }
}