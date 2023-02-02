package ru.bcomms.datagenerators;

import ru.bcomms.measurement.core.sensorgateway.SensorAdapter;
import ru.bcomms.measurement.entities.BinarySensorData;

import java.util.Date;
import java.util.Random;

public class BinarySignalSensor {
    private SensorAdapter sensorAdapter;
    private final Random random = new Random();
    private final int NUMBER_OF_SENSORS = 10;

    public BinarySignalSensor(SensorAdapter sensorAdapter) {
        this.sensorAdapter = sensorAdapter;
    }

    public boolean getSensorData() {
        Date date = new Date();
        int sensorId = random.nextInt(NUMBER_OF_SENSORS);
        boolean condition = random.nextBoolean();
        return sensorAdapter.create(new BinarySensorData(sensorId, date, condition));
    }
}
