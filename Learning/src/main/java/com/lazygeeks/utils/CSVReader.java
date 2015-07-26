package com.lazygeeks.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a generic class implemented to read CSV files
 */
public class CSVReader {

    private String fileName;
    
    private boolean hasHeaders;
    
    private String[] headers = new String[0];
    
    private final String SEPERATOR = ",";
    
    /**
     * Constructor with fileName;
     * 
     * @param fileName - inputFile 
     */
    public CSVReader(String fileName){
	this(fileName,false);
    }

    /**
     * Constructor with FileName and header info
     * 
     * @param fileName - inputFile
     * @param hasHeaders - has Header information
     */
    public CSVReader(String fileName, boolean hasHeaders){
	this.fileName = fileName;
	this.hasHeaders = hasHeaders;
    }

    /**
     * Get the fileName 
     * @return - fileName used.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * set the fileName used to read;
     * 
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * check if the file has header information
     * 
     * @return  true if file has headers
     * 		false otherwise
     */
    public boolean hasHeaders() {
        return hasHeaders;
    }

    /**
     * update the header information for the file.
     * @param hasHeaders
     */
    public void setHasHeaders(boolean hasHeaders) {
        this.hasHeaders = hasHeaders;
    }
    
    /**
     * Get header information for the file.
     * @param hasHeaders
     */
    public String[] getHeaders() {
        return this.headers;
    }
    
    
    /**
     * Reads the given file and returns the content of the file.
     * Headers are not included. use {@code getHeaders} to get the header details.
     * 
     * @return - List<String[]> : each array contains each line.
     * @throws IOException
     */
    public List<Object[]> readFile() throws IOException {
	List<Object[]> retValue = new ArrayList<Object[]>();
	String line = null;

	// check file exists and readable
	if(this.getClass().getResource(fileName) == null){
	    throw new FileNotFoundException(fileName +" Not found");
	}else{
	    fileName = this.getClass().getResource(fileName).getFile(); 
	    BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
	
	    // check if file has headers
	    if (hasHeaders) {
		String headerStr = br.readLine();
		headers = headerStr.split(SEPERATOR);
	    }

	    // read and return data
	    while ((line = br.readLine()) != null) {
		Object[] splitData = line.split(SEPERATOR);
		retValue.add(splitData);
	    }
	}
	return retValue;
    }
}
