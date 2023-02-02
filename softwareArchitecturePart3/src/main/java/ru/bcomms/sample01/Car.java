package ru.bcomms.sample01;

import java.awt.*;

public abstract class Car {

    //region Public Methods

    private Refueling refuelingStation;

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refuelingStation = refuelingStation;
        fuel();
    }

    public void fuel() {
        refuelingStation.fuel(fuelType);
    }

    // Движение
    public abstract void movement();

    // Обслуживание
    public abstract void maintenance();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadlights();

    // Включение дворников
    public abstract boolean switchWipers();

    // Включение противотуманных фар
    public boolean switchFogLights() {
        fogLights = !fogLights;
        return fogLights;
    }

    public void shipping() {
        System.out.printf("Автомобиль перевозит груз весом %d кг.\n", loadCapacity);
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    //endregion

    //region Private Fields

    private int loadCapacity;

    // Противотуманные фары (состояние)
    private boolean fogLights = false;

    // Марка автомобиля
    private String make;
    // Модель
    private String model;
    // Цвет
    private Color color;
    // Тип
    private CarType type;
    // Число колес
    protected int wheelsCount;
    // Тип топлива
    protected FuelType fuelType;
    // Тип коробки передач
    private GearboxType gearboxType;
    // Объем двигателя
    private double engineCapacity;

    //endregion

}

