package com.revature.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncrypter {
	private final LogHelper log = new LogHelper();
    private final Random random = new SecureRandom();  
    private final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";  
    private final int iterations = 10000;  
    private final int keylength = 256;  
    
    public final String path = "C:\\FileTest\\salt.txt";
    
    
    public String getSaltvalue(int length)   
    {  
        StringBuilder finalval = new StringBuilder(length);  
  
        for (int i = 0; i < length; i++)   
        {  
            finalval.append(characters.charAt(random.nextInt(characters.length())));  
        }  
  
        return new String(finalval);  
    }
    
    public byte[] hash(char[] password, byte[] salt)   
    {  
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keylength);  
        Arrays.fill(password, Character.MIN_VALUE);  
        try   
        {  
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");  
            return skf.generateSecret(spec).getEncoded();  
        }   
        catch (NoSuchAlgorithmException | InvalidKeySpecException e)   
        {  
            log.callErrorLogger(e);
            return null;
        }   
        finally   
        {  
            spec.clearPassword();  
        }  
    } 
    
    public String generateSecurePassword(String password, String salt)   
    {  
        String finalval = null;  
  
        byte[] securePassword = this.hash(password.toCharArray(), salt.getBytes());  
   
        finalval = Base64.getEncoder().encodeToString(securePassword);  
   
        return finalval;  
    }
    
    public boolean verifyUserPassword(String providedPassword,  
            String securedPassword, String salt)  
    {  
        boolean finalval = false;  
          
        /* Generate New secure password with the same salt */  
        String newSecurePassword = this.generateSecurePassword(providedPassword, salt);  
          
        /* Check if two passwords are equal */  
        finalval = newSecurePassword.equalsIgnoreCase(securedPassword);  
          
        return finalval;  
    }
    
    public String downloadSalt() {
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(this.path));
    	    StringBuilder sb = new StringBuilder();
    	    String line = br.readLine();

    	    while (line != null) {
    	        sb.append(line);
    	        sb.append(System.lineSeparator());
    	        line = br.readLine();
    	    }
    	    br.close();
    	    return sb.toString();
    	} catch(IOException e) {
    		log.callErrorLogger(e);
    		return null;
    	}
    }
}
