package ru.bcomms.measurement.core.reports;

import ru.bcomms.database.Database;
import ru.bcomms.measurement.entities.SensorData;
import ru.bcomms.measurement.entities.SensorType;

import java.util.Collection;
import java.util.stream.Collectors;

public class AnalogShortReport implements ShortReport {
    @Override
    public Collection<SensorData> getSensorData(Database database, int sensorId) {
        return database.getAll()
                .stream()
                .filter(s -> s.getSensorType().equals(SensorType.ANALOG) && s.getSensorId() == sensorId)
                .collect(Collectors.toList());
    }
}
