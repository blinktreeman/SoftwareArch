package ru.bcomms.measurement.entities;

import java.util.Date;

public class BinarySensorData extends SensorData {
    private final boolean sensorData;

    public BinarySensorData(int sensorId, Date date, boolean sensorData) {
        super(sensorId, date);
        this.sensorData = sensorData;
        this.setSensorType(SensorType.BINARY);
    }

    public boolean getSensorData() {
        return sensorData;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                " value = " + sensorData +
                " }";
    }
}
