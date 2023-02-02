package ru.bcomms.measurement.core.reports;

import ru.bcomms.database.Database;
import ru.bcomms.measurement.entities.SensorData;
import ru.bcomms.measurement.entities.SensorType;

import java.util.Collection;
import java.util.stream.Collectors;

public class BinaryFullReport implements FullReport {
    @Override
    public Collection<SensorData> getSensorData(Database database) {
        return database.getAll()
                .stream()
                .filter(s -> s.getSensorType().equals(SensorType.BINARY))
                .collect(Collectors.toList());
    }
}
