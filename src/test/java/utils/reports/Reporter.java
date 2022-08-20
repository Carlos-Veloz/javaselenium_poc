package utils.reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.PropertiesConfig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Setup the reporter ExtentSparkReport
 * This setup does not support parallel execution
 *
 * @lastmodifier Cecilia Ocampo
 */
public class Reporter {
    public static String reportPath = PropertiesConfig.EXTENT_REPORT_PATH;
    private static LocalDateTime date = LocalDateTime.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHHmmss");
    public static ExtentSparkReporter htmlReport;
    public static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;

    public static void setupExtentReport() {
        htmlReport = new ExtentSparkReporter(reportPath + date.format(formatter) + "-ExtentReport.html");
        htmlReport.config().setDocumentTitle("Execution Report");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setReportName("Sauce Demo");

        extent.attachReporter(htmlReport);
    }

}
