package extent;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersImplementationClass implements ITestListener {

	  ExtentReports report;
	    ExtentTest test;

	    public void onTestStart(ITestResult result) {
	        if (report != null) {
	            test = report.createTest(result.getMethod().getMethodName());
	        } else {
	            System.out.println("ExtentReports object not initialized. Test start failed.");
	        }
	    }

	    public void onTestSuccess(ITestResult result) {
	        if (test != null) {
	            test.log(Status.PASS, result.getMethod().getMethodName());
	            test.log(Status.PASS, result.getThrowable());
	        } else {
	            System.out.println("ExtentTest object not initialized. Test success log failed.");
	        }
	    }
	    
	    public void onTestFailure(ITestResult result) {
	        if (test != null) {
	            test.log(Status.FAIL, result.getMethod().getMethodName());
	            test.log(Status.FAIL, result.getThrowable());
	            try {
	                String screenShotName = WebDriverUtility.takeScreenShot(BaseClass.sDriver, result.getMethod().getMethodName());
	                test.addScreenCaptureFromPath(screenShotName);
	            } catch (Throwable e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("ExtentTest object not initialized. Test failure log failed.");
	        }
	    }
	    
	    public void onStart(ITestContext context) {
	        ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/vtigerReport.html");


	        spark.config().setTheme(Theme.DARK);
	        spark.config().setReportName("Vtiger Extent Report");
	        spark.config().setDocumentTitle("Vtiger Report");


	        report = new ExtentReports();
	        report.attachReporter(spark);
	        report.setSystemInfo("createdBy", "Akash");
	        report.setSystemInfo("ReviwedBy", "Deepak");
	        report.setSystemInfo("platform", "windows11");
	        report.setSystemInfo("ServerName", "ApacheTomcat");
	    }

	    public void onFinish(ITestContext context) {
	        if (report != null) {
	            report.flush();
	        } else {
	            System.out.println("ExtentReports object not initialized. Report flushing failed.");
	        }
	    }
		    public void onTestSkipped(ITestResult result) {
		        if (test != null) {
		            test.log(Status.SKIP, result.getMethod().getMethodName());
		            test.log(Status.SKIP, result.getThrowable());
		        } else {
		            System.out.println("ExtentTest object not initialized. Test skipped log failed.");
		        }
		    }




}
