package com.epam.reportportal.example.testng.logback.randomizer;

import com.epam.reportportal.example.testng.logback.MagicRandomizer;
import org.testng.annotations.Test;

/**
 * Tests for Randomizer boundaries
 *
 * @author Andrei Varabyeu
 */
public class TestRandomizerBoundaries {

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testLowerBoundExceeded() {
		MagicRandomizer.checkYourLucky(-1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testHigherBoundExceeded() {
		MagicRandomizer.checkYourLucky(101);
	}

	@Test
	public void testHigherBound() {
		MagicRandomizer.checkYourLucky(100);
	}

	@Test
	public void testLowerBound() {
		MagicRandomizer.checkYourLucky(1);
	}
}
