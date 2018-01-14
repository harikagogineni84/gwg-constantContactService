package com.gwg.constantContact.signup;
import static org.junit.Assert.*;

import javax.crypto.BadPaddingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwg.constantContact.signup.ResponseEncrypter;
@RunWith(SpringRunner.class)
@SpringBootTest

public class ResponseEncrypterTest {
	
	static String input = "{\"output\":\"...why is so cold?\nMy house is literally 50F right now.\"}";
	
	@Test
	public void shouldEncryptThenDecrypt(){
	String key = "banana";
	String encryptionResult = ResponseEncrypter.encrypt(input,key);
	assertNotEquals(input, encryptionResult);
	String decryptionResult = ResponseEncrypter.decrypt(encryptionResult,key);
	assertEquals(input, decryptionResult);
	
	String key2 = "elephant";
	String decryptionResult2 = ResponseEncrypter.decrypt(encryptionResult,key2);
	assertNotEquals(decryptionResult, decryptionResult2);
	}
}
