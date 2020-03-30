package com.epam.reportportal.example.cucumber.logging;

import com.epam.reportportal.annotations.TestCaseId;
import com.epam.reportportal.annotations.TestCaseIdKey;
import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCaseIdTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestCaseIdTest.class);

	@Given("^Test case id should be generated based on code reference$")
	public void testCaseIdFromCodeRef() {
		LOGGER.info("Test case id should be generated based on code reference");
	}

	@Given("^Test case id should be generated based on code reference and (\\d+)$")
	public void testCaseIdFromCodeRefAndParameters(int parameter) {
		LOGGER.info("Test case id should be generated based on code reference and parameter '{}'", parameter);
	}

	@TestCaseId("test-case-id")
	@Given("^Test case id should be generated based on annotation value$")
	public void testCaseIdFromAnnotationValue() {
		LOGGER.info("Test case id should be generated based on annotation value");
	}

	@TestCaseId(parametrized = true)
	@Given("^Test case id should be generated based on annotated parameter (.*)$")
	public void testCaseIdFromAnnotationParameterized(@TestCaseIdKey String parameter) {
		LOGGER.info("Test case id should be generated based on annotated parameter value '{}'", parameter);
	}
}
