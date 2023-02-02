package ru.bcomms.measurement.core.reports;


import ru.bcomms.database.Database;
import ru.bcomms.measurement.entities.SensorData;

import java.util.Collection;

public interface ShortReport {
    Collection<SensorData> getSensorData(Database database, int sensorId);
}
