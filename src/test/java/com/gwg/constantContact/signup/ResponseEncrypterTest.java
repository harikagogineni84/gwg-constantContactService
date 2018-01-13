package com.gwg.constantContact.signup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwg.constantContact.signup.ResponseEncrypter;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseEncrypterTest {
	
	
	@Test
	public void shouldEncrypt(){
	String key = "banana";
	String response = ResponseEncrypter.encrypt("...why is so cold?\nMy house is literally 50F right now.",key);
	System.out.print(response);
	}
}
