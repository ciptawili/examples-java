package com.epam.reportportal.example.cucumber4.logging;

import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertEquals;

public class ReportsStepWithDefectTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReportsStepWithDefectTest.class);

	@Given("Test is skipped")
	public void testSkipped() {
		LOGGER.info("I must be skipped");
	}

	@Given("^Test is failed$")
	public void testFailure() {
		assertEquals(2, 1);
	}

	@Given("^Test is failed with message$")
	public void testFailureWithMessage() {
		assertEquals(2, 1, "Failure msg");
	}
}
