package utils.reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.PropertiesConfig;

/**
 * Setup the reporter ExtentSparkReport
 * This setup does not support parallel execution
 *
 * @lastmodifier Cecilia Ocampo
 */
public class Reporter {
    public static String reportPath = PropertiesConfig.EXTENT_REPORT_PATH; //TODO don't overwrite report
    public static ExtentSparkReporter htmlReport = new ExtentSparkReporter(reportPath);
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setupExtentReport() {
        extent = new ExtentReports();
        extent.attachReporter(htmlReport);

        htmlReport.config().setDocumentTitle("Execution Report");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setReportName("Sauce Demo");
    }

}
