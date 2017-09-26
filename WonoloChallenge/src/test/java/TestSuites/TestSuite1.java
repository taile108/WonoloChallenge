package TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import NewJob.NewJobTests;

@RunWith(Suite.class)
@SuiteClasses({
	NewJobTests.class,
	Others.OtherTests.class
	
})

public class TestSuite1 {

}
