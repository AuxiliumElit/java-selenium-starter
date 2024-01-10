package com.example.javaseleniumstarter.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExtentReportNg {
    public static ExtentReports getReportObject() {

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate currentDate = currentTime.toLocalDate();
        String path = System.getProperty("user.dir") + "//reports//" + currentDate.toString() + "TestReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Auxilium Elit");
        return extent;
    }
}
