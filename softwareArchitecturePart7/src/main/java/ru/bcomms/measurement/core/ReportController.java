package ru.bcomms.measurement.core;

import ru.bcomms.database.Database;
import ru.bcomms.database.SensorsDatabase;
import ru.bcomms.measurement.core.reports.AnalogFactory;
import ru.bcomms.measurement.core.reports.BinaryFactory;
import ru.bcomms.measurement.core.reports.ReportFactory;
import ru.bcomms.measurement.entities.SensorType;
import ru.bcomms.templates.FullReportTemplate;
import ru.bcomms.templates.ShortReportTemplate;
import ru.bcomms.templates.Template;

public class ReportController {
    Database database = SensorsDatabase.getInstance();
    ReportFactory reportFactory;
    Template template;

    public void getFullReport(SensorType sensorType) {
        switch (sensorType) {
            case ANALOG -> reportFactory = new AnalogFactory();
            case BINARY -> reportFactory = new BinaryFactory();
        }
        template = new FullReportTemplate();
        template.showReport(reportFactory.createFullReport().getSensorData(database));
    }

    public void getShortReport(SensorType sensorType, int sensorId) {
        switch (sensorType) {
            case ANALOG -> reportFactory = new AnalogFactory();
            case BINARY -> reportFactory = new BinaryFactory();
        }
        template = new ShortReportTemplate();
        template.showReport(reportFactory.createShortReport().getSensorData(database, sensorId));
    }
}
