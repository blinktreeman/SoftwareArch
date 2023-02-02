package ru.bcomms.templates;

import ru.bcomms.measurement.entities.SensorData;

import java.util.Collection;

public class ShortReportTemplate implements Template {
    @Override
    public void showReport(Collection<SensorData> sensorData) {
        System.out.println("Short report:");
        sensorData.forEach(System.out::println);
    }
}
