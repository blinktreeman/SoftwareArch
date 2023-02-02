package ru.bcomms.measurement.core;

import ru.bcomms.database.Database;
import ru.bcomms.database.SensorsDatabase;
import ru.bcomms.datagenerators.AnalogSignalSensor;
import ru.bcomms.datagenerators.BinarySignalSensor;
import ru.bcomms.measurement.core.sensorgateway.SensorAdapter;
import ru.bcomms.measurement.core.sensorgateway.SensorGateway;

public class InitDatabase {
    Database database = SensorsDatabase.getInstance();
    SensorAdapter sensorAdapter = new SensorGateway(database);
    // Два типа датчиков
    AnalogSignalSensor analogSignalSensor = new AnalogSignalSensor(sensorAdapter);
    BinarySignalSensor binarySignalSensor = new BinarySignalSensor(sensorAdapter);

    public void setDatabase() {
        // Генерируем данные от датчиков
        for (int i = 0; i < 5; i++) {
            analogSignalSensor.getSensorData();
            binarySignalSensor.getSensorData();
        }
    }
}
