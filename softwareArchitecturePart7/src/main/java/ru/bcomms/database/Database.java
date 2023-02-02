package ru.bcomms.database;

import ru.bcomms.measurement.entities.SensorData;

import java.util.Collection;
import java.util.UUID;

public interface Database {
    boolean create(SensorData item);
    SensorData read(UUID uuid);
    boolean delete(UUID uuid);
    Collection<SensorData> getAll();
}
