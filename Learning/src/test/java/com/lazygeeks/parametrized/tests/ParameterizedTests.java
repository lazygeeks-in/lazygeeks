package com.lazygeeks.parametrized.tests;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lazygeeks.parametrized.Calculator;
import com.lazygeeks.utils.CSVReader;

/**
 * Learning Parameterized Tests
 */
@RunWith(value = Parameterized.class)
public class ParameterizedTests {

	private Calculator obj = null;

	private String a;
	private String b;
	private String expected;

	public ParameterizedTests(String a, String b, String expected) {
		obj = new Calculator();

		this.a = a;
		this.b = b;
		this.expected = expected;
	}

	@Test
	public void testAdd() {
		int retValue = obj.add(Integer.parseInt(a) , Integer.parseInt(b) );
		Assert.assertEquals(retValue, Integer.parseInt(expected) );
	}

	@Parameters(name = "testAdd( {0},{1} )={2}")
	public static List<Object[]> getData() throws IOException {
		CSVReader reader = new CSVReader("/ParameterizedTest_inputs.csv", true);
		List retValue = reader.readFile();
		return retValue;
	}
}
