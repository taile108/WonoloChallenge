package Others;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.BeforeClass;
import org.junit.Test;

import config.WebDriverFactory;

public class OtherTests extends WebDriverFactory {
	
	@BeforeClass
	public static void setup() throws MalformedURLException {

	}

	@Test()
	public void otherTest_01() throws InterruptedException {
		System.out.println("Example for a test FAILED");
		assertTrue(false);
	}

	@Test() public void otherTest_02() throws InterruptedException {
		System.out.println("Example for a test PASSED");
		assertTrue(true);
	}

	@Test() public void otherTest_03() throws InterruptedException {
		System.out.println("Example for a test FAILED");
		assertTrue(false);
	}
	

	@Test() public void otherTest_04() throws InterruptedException {
		System.out.println("Example for a test PASSED");
		assertTrue(true);
	}
	
	

}
