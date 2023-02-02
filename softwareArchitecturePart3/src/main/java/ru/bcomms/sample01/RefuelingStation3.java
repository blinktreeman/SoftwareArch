package ru.bcomms.sample01;

/**
 * Заправочная станция
 */

public class RefuelingStation3 implements Refueling {
    @Override
    public void fuel(FuelType fuelType) {

        switch (fuelType) {
            case Diesel -> throw new RuntimeException("Дизельное топливо отсутствует.");
            case Gasoline -> System.out.println("Заправка бензином.");
        }
    }
}