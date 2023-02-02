package ru.bcomms.measurement.core.sensorgateway;

import ru.bcomms.database.Database;
import ru.bcomms.measurement.entities.SensorData;

public class SensorGateway implements SensorAdapter {
    Database database;

    public SensorGateway(Database database) {
        this.database = database;
    }

    @Override
    public boolean create(SensorData sensorData) {
        return database.create(sensorData);
    }
}
