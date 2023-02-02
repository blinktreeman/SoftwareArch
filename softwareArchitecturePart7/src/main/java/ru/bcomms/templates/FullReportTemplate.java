package ru.bcomms.templates;

import ru.bcomms.measurement.entities.SensorData;

import java.util.Collection;
import java.util.Comparator;

public class FullReportTemplate implements Template {
    @Override
    public void showReport(Collection<SensorData> sensorData) {
        System.out.println("Full report:");
        sensorData.stream()
                .sorted(Comparator.comparing(SensorData::getSensorId))
                .forEach(System.out::println);
    }
}
