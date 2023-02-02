package ru.bcomms;

import ru.bcomms.database.Database;
import ru.bcomms.database.SensorsDatabase;
import ru.bcomms.datagenerators.AnalogSignalSensor;
import ru.bcomms.datagenerators.BinarySignalSensor;
import ru.bcomms.measurement.core.InitDatabase;
import ru.bcomms.measurement.core.ReportController;
import ru.bcomms.measurement.core.sensorgateway.SensorAdapter;
import ru.bcomms.measurement.core.sensorgateway.SensorGateway;
import ru.bcomms.measurement.core.reports.AnalogFactory;
import ru.bcomms.measurement.core.reports.ReportFactory;
import ru.bcomms.measurement.entities.SensorType;

public class App {
    public static void main(String[] args) {

        InitDatabase initDatabase = new InitDatabase();
        initDatabase.setDatabase();

        ReportController reportController = new ReportController();
        reportController.getFullReport(SensorType.ANALOG);

        reportController.getShortReport(SensorType.BINARY, 3);

    }
}

/*
Output:
Full report:
SensorData { sensorId=1, date=Mon Dec 19 01:23:54 GMT+07:00 2022 }{ value = 0.15091383986065698 }
SensorData { sensorId=1, date=Mon Dec 19 01:23:54 GMT+07:00 2022 }{ value = 0.8828998999724209 }
SensorData { sensorId=4, date=Mon Dec 19 01:23:54 GMT+07:00 2022 }{ value = 0.37964181125230345 }
SensorData { sensorId=6, date=Mon Dec 19 01:23:54 GMT+07:00 2022 }{ value = 0.0386166796877504 }
SensorData { sensorId=7, date=Mon Dec 19 01:23:54 GMT+07:00 2022 }{ value = 0.3584601018211824 }
Short report:
SensorData { sensorId=3, date=Mon Dec 19 01:23:54 GMT+07:00 2022 }{ value = true }
 */