package ru.bcomms.measurement.core.sensorgateway;

import ru.bcomms.measurement.entities.SensorData;

public interface SensorAdapter {
    boolean create(SensorData sensorData);
}
