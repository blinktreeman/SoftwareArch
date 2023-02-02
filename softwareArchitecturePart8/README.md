# softwareArchitecturePart8

## Задание

> Доработать метод changeReservationTable, протянуть возможность изменения
> резерва столика на уровне компонент BookingPresenter и BookingModel

## Решение

Для реализации изменения резервируемого столика выполняем:

----

Для возможности удаления резерва в класс Table добавляем метод removeReservation

```java
public boolean removeReservation(int idToRemove) {
        Reservation reservation = reservations.stream()
                .filter(r -> r.getId() == idToRemove)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No reservation found"));
        return reservations.remove(reservation);
}
```

----
Для интерфейса Model объявляем метод changeReservationTable

```java
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
```

В классе BookingModel реализуем метод changeReservationTable

```java
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
```

----
Для интерфейса ViewObserver объявляем метод onChangeReservationTable

```java
public interface ViewObserver {
    void onReservationTable(Date reservationDate, int tableNo, String name);
    void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
```

и реализуем его в BookingPresenter

```java
@Override
public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
    int reservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
    printReservationTableResult(reservationNo);
}
```

----

И в завершении добавляем метод changeReservationTable для изменения брони во view (класс BookingView)

```java
public void  changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
    observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
}
```

----

## Результат

При вызове из main метода:

```java
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
```

Вывод (к выводу добавлен номер столика):

```
Столик #1
Столик #2
Столик #3
Столик #4
Столик #5

Столик #3 успешно забронирован. Номер вашей брони #1
Столик #5 успешно забронирован. Номер вашей брони #2
```
