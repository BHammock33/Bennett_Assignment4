package com.coderscampus.myapp.service;

import java.io.FileReader;
import java.io.IOException;

public class MyService {

	public int multiply (int a, int b) {
		return a*b;
	}
	
	/**
	 * This method is intentionally useless to the assignments and exercises
	 * in the bootcamp. Follow instructions for those, this is for 
	 * demonstrating the testability of the code only
	 * 
	 * @param filePath
	 * @return
	 */
	public String fileContents(String filePath) {
		String returnValue = null;
		try {
		      FileReader fileReader=new FileReader(filePath);    
		      StringBuilder content = new StringBuilder();
		      int nextChar;
		      while ((nextChar = fileReader.read()) != -1) {
		          content.append((char) nextChar);
		      }
		      return String.valueOf(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}
