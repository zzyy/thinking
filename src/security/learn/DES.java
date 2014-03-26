package security.learn;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

public class DES {

	public static String algorithm = "DES"; 
	public static String key="abcdefgh";
	
	@Test public void testDES(){
		try {
			DESKeySpec dsk = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
			SecretKey secretKey = keyFactory.generateSecret(dsk);
			System.out.println(new String(secretKey.getEncoded()));
//			secretKey = new SecretKeySpec(key.getBytes(), algorithm);
//			System.out.println(new String(secretKey.getEncoded()));
			
			System.out.println("原数据: " + key);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] result = cipher.doFinal(key.getBytes());
			System.out.println("加密后: " +result);
			
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			result = cipher.doFinal(result);
			System.out.println("解密后: " + new String(result));
			
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
