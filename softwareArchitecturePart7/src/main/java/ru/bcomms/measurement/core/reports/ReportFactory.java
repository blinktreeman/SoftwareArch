package ru.bcomms.measurement.core.reports;

public interface ReportFactory {
    FullReport createFullReport();
    ShortReport createShortReport();
}
