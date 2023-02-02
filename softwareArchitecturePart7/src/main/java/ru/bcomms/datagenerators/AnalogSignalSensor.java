package ru.bcomms.datagenerators;

import ru.bcomms.measurement.core.sensorgateway.SensorAdapter;
import ru.bcomms.measurement.entities.AnalogSensorData;

import java.util.Date;
import java.util.Random;

public class AnalogSignalSensor {
    private final SensorAdapter sensorAdapter;
    private final Random random = new Random();
    private final int NUMBER_OF_SENSORS = 10;

    public AnalogSignalSensor(SensorAdapter sensorAdapter){
        this.sensorAdapter = sensorAdapter;
    }

    public boolean getSensorData() {
        Date date = new Date();
        int sensorId = random.nextInt(NUMBER_OF_SENSORS);
        double condition = random.nextDouble();
        return sensorAdapter.create(new AnalogSensorData(sensorId, date, condition));
    }
}
