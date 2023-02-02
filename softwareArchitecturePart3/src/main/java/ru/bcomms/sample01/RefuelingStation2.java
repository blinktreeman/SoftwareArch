package ru.bcomms.sample01;

/**
 * Заправочная станция
 */

public class RefuelingStation2 implements Refueling {
    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println("Заправка дизельным топливом.");
            case Gasoline -> System.out.println("Заправка бензином.");
        }
    }
}