package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

    public ExtentReports extent;
    public ExtentSparkReporter spark;


    /*@BeforeSuite
    public void setupReport()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("Spark.html");
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void teardownReport()
    {
        extent.flush();
    }*/

}