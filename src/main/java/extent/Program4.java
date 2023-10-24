package extent;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Program4 {

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report2.html");
		extent.attachReporter(spark);
		
		extent
		.createTest("Test1","Test Description")
		.assignAuthor("Raju")
		.assignCategory("smoke")
		.assignDevice("Chrome99")
		.pass("This is a passed test");
		
		extent
		.createTest("Test3","Test Description")
		.assignAuthor("Raju","Mohan","Sohan")
		.assignCategory("smoke")
		.assignDevice("Chrome99")
		.pass("This is a passed test");
		
		extent
		.createTest("Test2","Test Description")
		.assignAuthor("Ayush")
		.assignCategory("Sanity")
		.assignDevice("Edge99")
		.fail("This is a failed test");
		extent.flush();
		Desktop.getDesktop().browse(new File("report2.html").toURI());
	}

}
