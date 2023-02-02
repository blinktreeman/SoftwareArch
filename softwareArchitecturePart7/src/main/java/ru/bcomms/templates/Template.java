package ru.bcomms.templates;

import ru.bcomms.measurement.entities.SensorData;

import java.util.Collection;

public interface Template {
    void showReport(Collection<SensorData> sensorData);
}
