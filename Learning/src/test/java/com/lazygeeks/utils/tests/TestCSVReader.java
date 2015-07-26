package com.lazygeeks.utils.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.lazygeeks.utils.CSVReader;

public class TestCSVReader {
    
    private final String FILENAME = "/sample.csv";
    
    private final String FILENAME_NOHEADERS = "/sample_noheaders.csv";
    
    @Test
    public void testNoHeaders(){
    	CSVReader csvReader = new CSVReader(FILENAME_NOHEADERS, false);
    	try {
			List<Object[]> retValue = csvReader.readFile();
			Assert.assertEquals(csvReader.getHeaders().length, 0);
			
			// Assert size of data 
			Assert.assertEquals(retValue.size(),6);
		} catch (IOException e) {
			Assert.fail("File cannot be found");
			e.printStackTrace();
		}
    	
    }
    
    @Test
    public void testDataSize(){
	CSVReader csvReader = new CSVReader(FILENAME, true);
	List<Object[]> retValue;
	try {
	    retValue = csvReader.readFile();
	    Assert.assertEquals(retValue.size(),5);

	    // lenght of the data
	    Assert.assertEquals(retValue.get(0).length,4);
	    Assert.assertEquals(retValue.get(1).length,4);
	    Assert.assertEquals(retValue.get(2).length,4);
	    Assert.assertEquals(retValue.get(3).length,4);
	    Assert.assertEquals(retValue.get(4).length,4);
	    
	}  catch (FileNotFoundException e) {
	    Assert.fail("Failed to load file ");
	    e.printStackTrace();
	}catch (IOException e) {
	    Assert.fail("Unable to read data from file");
	    e.printStackTrace();
	}
    }
    
    @Test
    public void testHeaders(){
	CSVReader csvReader = new CSVReader(FILENAME, true);
	List<Object[]> retValue;
	try {
	    retValue = csvReader.readFile();
	    Assert.assertEquals(retValue.size(),5);
	    String[] expectedHeaders={"No","Name","Age","Salary"};
	    
	    Assert.assertArrayEquals(csvReader.getHeaders(),expectedHeaders);
	    
	} catch (FileNotFoundException e) {
	    Assert.fail("Failed to load file ");
	    e.printStackTrace();
	}catch (IOException e) {
	    Assert.fail("Unable to read data from file");
	    e.printStackTrace();
	}
    }

    @Test
    public void testDataInFile(){
	CSVReader csvReader = new CSVReader(FILENAME, true);
	List<Object[]> retValue;
	try {
	    retValue = csvReader.readFile();
	    String[][] expectedHeaders={
		    {"1","Pavan","32","100000"},
		    {"2","Samir","34","100000"},
		    {"3","Venu","58","75000"},
		    {"4","Nagendar","58","75000"},
		    {"5","Harsha","7","100"}
		    };
	    
	    Assert.assertArrayEquals(retValue.toArray(), expectedHeaders);
	} catch (FileNotFoundException e) {
	    Assert.fail("Failed to load file ");
	    e.printStackTrace();
	}catch (IOException e) {
	    Assert.fail("Unable to read data from file");
	    e.printStackTrace();
	}
    }
}
