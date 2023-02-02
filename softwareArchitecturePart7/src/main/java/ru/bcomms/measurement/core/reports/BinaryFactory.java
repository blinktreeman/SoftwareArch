package ru.bcomms.measurement.core.reports;

public class BinaryFactory implements ReportFactory {
    @Override
    public FullReport createFullReport() {
        return new BinaryFullReport();
    }

    @Override
    public ShortReport createShortReport() {
        return new BinaryShortReport();
    }
}
