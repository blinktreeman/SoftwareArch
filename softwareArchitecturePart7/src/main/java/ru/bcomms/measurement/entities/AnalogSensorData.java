package ru.bcomms.measurement.entities;

import java.util.Date;

public class AnalogSensorData extends SensorData {
    private final double sensorData;
    public AnalogSensorData(int sensorId, Date date, double sensorData) {
        super(sensorId, date);
        this.sensorData = sensorData;
        this.setSensorType(SensorType.ANALOG);
    }

    public double getSensorData() {
        return sensorData;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                " value = " + sensorData +
                " }";
    }
}
