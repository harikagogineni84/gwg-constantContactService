package com.gwg.constantContact.signup;

import javax.crypto.Cipher;

public class ResponseEncrypter {

	public static String encrypt(String response, String privateKey) {
		
	    byte[] cipherText = null;
	    try {
	      // get an RSA cipher object and print the provider
	      final Cipher cipher = Cipher.getInstance(ALGORITHM);
	      // encrypt the plain text using the public key
	      cipher.init(Cipher.ENCRYPT_MODE, key);
	      cipherText = cipher.doFinal(text.getBytes());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	    
		return response;
	}

}
