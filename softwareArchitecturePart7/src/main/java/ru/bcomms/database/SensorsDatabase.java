package ru.bcomms.database;

import ru.bcomms.measurement.entities.SensorData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class SensorsDatabase implements Database {
    private static SensorsDatabase instance;
    private final List<SensorData> database = new ArrayList<>();

    private SensorsDatabase() {}
    public static SensorsDatabase getInstance() {
        if (instance == null) {
            instance = new SensorsDatabase();
        }
        return instance;
    }

    @Override
    public boolean create(SensorData item) {
        return database.add(item);
    }

    @Override
    public SensorData read(UUID uuid) {
        return database.stream()
                .filter(s -> s.getId().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Data not exist"));
    }

    @Override
    public boolean delete(UUID uuid) {
        //TODO....
        return false;
    }

    @Override
    public Collection<SensorData> getAll() {
        return database;
    }
}
