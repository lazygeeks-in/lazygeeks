package com.lazygeeks.parametrizedtests;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Learning Parameterized Tests
 */
@RunWith(value = Parameterized.class)
public class ParameterizedTests {

    private Calculator obj = null;
    
    private int a;
    private int b;
    private int expected;
    
    
    public ParameterizedTests(int a, int b, int expected){
	obj = new Calculator();
	
	this.a = a;
	this.b = b;
	this.expected = expected;
    }
    
    @Test
    public void testAdd(){
	int retValue =  obj.add(a, b);
	Assert.assertEquals(retValue, expected);
    }
    
    @Parameters(name="add {0}+{1}={2}")
    public static Iterable<Object[]> getData(){
	return Arrays.asList(new Object[][] { 
		{ 1, 1, 2 }, 
		{ 2, 2, 4 }, 
		{ 8, 2, 10 }, 
		{ 4, 5, 9 } 
	});
    }
}
