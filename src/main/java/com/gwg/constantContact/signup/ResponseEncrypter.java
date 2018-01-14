package com.gwg.constantContact.signup;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ResponseEncrypter {

	
	public static final String ALGORITHM = "Blowfish";
	public static final String ENCODE = "UTF8";
	
	public static String encrypt(String response, String privateKey) {
	
		try {
			SecretKeySpec keySpec = new SecretKeySpec(privateKey.getBytes(ENCODE), ALGORITHM);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE,keySpec);
			byte[] encrypted = cipher.doFinal(response.getBytes(ENCODE));
			response = Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return response;
	}
	
	public static String decrypt(String payloadHash, String privateKey) {
		
		//TODO: implementation entirely subject to change depending on what GWG would like to send us
		//TODO: this implementation is symmetric if it meets the organization's needs.
		
		try {
			SecretKeySpec keySpec = new SecretKeySpec(privateKey.getBytes(ENCODE), ALGORITHM);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, keySpec);			
			byte[] decryptedMessage = cipher.doFinal((Base64.getDecoder().decode(payloadHash)));
			payloadHash = new String(decryptedMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return payloadHash;
	}
	
}