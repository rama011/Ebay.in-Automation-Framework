package ebay.in.utils;

import org.testng.IClassListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestResult;

public class ListenerClass implements IInvokedMethodListener,ISuiteListener,IClassListener {

	@Override
	public void onBeforeClass(ITestClass testClass) {
		// TODO Auto-generated method stub
		System.out.println("Invoking class-----> "+testClass.getTestName());
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Starting Suite----> "+suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Completed Suite-----> "+suite.getName());
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		System.out.println("Invoking method ----> "+method.getTestMethod());
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

}
