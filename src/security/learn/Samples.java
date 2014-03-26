package security.learn;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

public class Samples {
	public String msg = "这是待加密的数据";
	
	//MD5 message digest 5
	@Test public void testMD5(){
		byte[] result = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(msg.getBytes());
			result = md5.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	//SHA
	@Test public void testSHA(){
		byte[] result = null;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA");
			sha.update(msg.getBytes());
			result = sha.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	//HMAC
	@Test public void testHMAC(){
		byte[] result = null;
		
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
			SecretKey key = keyGenerator.generateKey();
			System.out.println(key.getEncoded());
			key = new SecretKeySpec("zy".getBytes(), "HmacMD5");
			System.out.println(key.getEncoded());
			
			Mac mac = Mac.getInstance(key.getAlgorithm());
			mac.init(key);
			mac.update(msg.getBytes());
			result = mac.doFinal();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
}
