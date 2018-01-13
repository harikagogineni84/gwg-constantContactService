package com.gwg.constantContact.signup;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwg.constantContact.signup.ResponseEncrypter;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseEncrypterTest {
	
	static String response = "{\"output\":\"...why is so cold?\nMy house is literally 50F right now.\"}";
	
	@Test
	public void shouldEncryptThenDecrypt(){
	String key = "banana";
	String result = ResponseEncrypter.encrypt(response,key);
	assertNotEquals(result, response);
	result = ResponseEncrypter.decrypt(response,key);
	assertEquals(result, response);
	
	String key2 = "elephant";
	String result2 = ResponseEncrypter.decrypt(response,key2);
	assertNotEquals(result, result2);
	}
}
