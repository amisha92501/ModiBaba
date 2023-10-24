package extent;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
//import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class Program3 {
		static WebDriver driver;
	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report2.html");
		extent.attachReporter(spark);
		System.out.println("huu");
		driver=new FirefoxDriver();
		driver.get("https://www.google.com/");
		
		extent
		.createTest("Screenshot Test1", "This is for attaching the screenshot to the test at test level")
		.info("This is info msg")
		.addScreenCaptureFromBase64String(captureScreenshot());
		
		extent
		.createTest("Screenshot Test2", "This is for attaching the screenshot to the test at test level")
		.info("This is info msg")
		.addScreenCaptureFromBase64String(captureScreenshot(), "Google HomePage1")
		.addScreenCaptureFromBase64String(captureScreenshot(), "Google HomePage2")
		.addScreenCaptureFromBase64String(captureScreenshot(), "Google HomePage3")
		.addScreenCaptureFromBase64String(captureScreenshot(), "Google HomePage4");
		extent
		.createTest("Screenshot Test3", "This is for attaching the screenshot to the test at test level")
		.info("This is info msg")
		.addScreenCaptureFromPath(captureScreenshot("report1"));
		
		extent
		.createTest("Screenshot Test4", "This is for attaching the screenshot to the test at test level")
		.info("This is info msg")
		.addScreenCaptureFromPath(captureScreenshot("report2"), "Google");
		
		extent
		.createTest("Screenshot Test5", "This is for attaching the screenshot to the test at log level")
		
		.fail("This is image information",MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build());
		extent.flush();
		Desktop.getDesktop().browse(new File("report2.html").toURI());
		
	}
		
		public static String captureScreenshot(String fileName) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(".//Photo//"+fileName+".png");
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
		
			e.printStackTrace();
			}
		System.out.println("Screenshot saved successfully");
		 return destination.getAbsolutePath();
		}
		
		public static String captureScreenshot() {
			TakesScreenshot ts=(TakesScreenshot) driver;
			String base64Code=ts.getScreenshotAs(OutputType.BASE64);
			System.out.println("Screenshot saved successfully");
			return base64Code;
		}
}
		

	


