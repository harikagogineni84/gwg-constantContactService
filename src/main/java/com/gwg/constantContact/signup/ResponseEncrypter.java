package com.gwg.constantContact.signup;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ResponseEncrypter {

	
	public static final String ALGORITHM = "RSA";
	
	public static String encrypt(String response, String privateKey) {
		
	    byte[] cipherText = null;
	    byte[] decodedKey = Base64.getDecoder().decode(privateKey);
	    Key key = new SecretKeySpec(decodedKey,0,decodedKey.length, "RSA");
	    try {
	      final Cipher cipher = Cipher.getInstance(ALGORITHM);
	      cipher.init(Cipher.ENCRYPT_MODE, key);
	      cipherText = cipher.doFinal(response.getBytes());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	    response = cipherText.toString();
		return response;
	}

}