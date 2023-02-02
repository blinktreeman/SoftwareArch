package ru.bcomms.measurement.core.reports;

public class AnalogFactory implements ReportFactory {
    @Override
    public FullReport createFullReport() {
        return new AnalogFullReport();
    }

    @Override
    public ShortReport createShortReport() {
        return new AnalogShortReport();
    }
}
