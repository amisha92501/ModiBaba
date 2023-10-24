package extent;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Program1 {

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report2.html");
		extent.attachReporter(spark);
		ExtentTest test1=extent.createTest("Test1");
		//test1.pass("This is passed");
		
		ExtentTest test2=extent.createTest("Test1");
		//test2.log(Status.FAIL, "This is failed");
		
		extent.createTest("Test3");//.skip("This is skipped");
		extent.flush();
		Desktop.getDesktop().browse(new File("report2.html").toURI());
		
	

	}

}
