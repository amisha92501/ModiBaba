package extent;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Program2 {

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report2.html");
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest("Test");
			test
			.log(Status.INFO, "info1")
			.log(Status.INFO,"info2");
			/*.log(Status.PASS,"pass");
			.log(Status.WARNING,"warning")
			.log(Status.WARNING,"warning")
			.log(Status.SKIP,"skip")
			.log(Status.FAIL,"fail")
			.log(Status.FAIL,"fail2");*/
		extent.flush();
		Desktop.getDesktop().browse(new File("report2.html").toURI());

	}

}
