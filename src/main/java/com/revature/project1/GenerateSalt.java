package com.revature.project1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateSalt {
	
	private final static PasswordEncrypter encrypt = new PasswordEncrypter();
	private final static LogHelper log = new LogHelper();

	public static void main(String[] args) {
		 try {
			  File myObj = new File(encrypt.path);
			  FileWriter myWriter = new FileWriter(myObj);
			  myWriter.write(encrypt.getSaltvalue(30));
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      log.callErrorLogger(e);
		    }
		  }
}
