package ru.bcomms.measurement.core.reports;


import ru.bcomms.database.Database;
import ru.bcomms.measurement.entities.SensorData;

import java.util.Collection;

public interface FullReport {
    Collection<SensorData> getSensorData(Database database);
}
