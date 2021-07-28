package assign4.junit.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(JunitTrigonometricFunctionsTestClass.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		// System.out.println("Total no of test case run: "+result.toString());
		System.out.println("Total no of failures: " + result.getFailureCount());
		System.out.println("Total no of test run: " + result.getRunCount());
		System.out.println("All tests were successfull: " + result.wasSuccessful());
	}

}
