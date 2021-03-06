package com.epam.reportportal.example.testng.logback.parameterized;

import com.epam.reportportal.annotations.ParameterKey;
import com.epam.reportportal.annotations.UniqueID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Parametrized test. You should get all parameters. Custom keys for parameters
 * Custom uniqueID.
 *
 * @author Pavel Bortnik
 */
public class ParameterizedTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParameterizedTest.class);

	@Test
	@Parameters({ "message" })
	@UniqueID("HOOOOAA-my-very-unique-id")
	public void testParametersFromSuite(String msg) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			LOGGER.info(msg + ": " + i);
			if (i == 1) {
				Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
			}
		}
	}

	@Test(threadPoolSize = 2, dataProvider = "bla-bla")
	public void testParametersFromDataProvider(@ParameterKey("my_great_parameter") String msg, String msg2) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			LOGGER.info(msg + ": " + msg2);
			if (i == 1) {
				Thread.sleep(TimeUnit.SECONDS.toMillis(5L));
			}
		}
	}

	@DataProvider(parallel = true, name = "bla-bla")
	public Iterator<Object[]> params() {
		return Arrays.asList(new Object[] { "one", "two" }, new Object[] { "two", "one" }, new Object[] { "three", null }).iterator();
	}

}
