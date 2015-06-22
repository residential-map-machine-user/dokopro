package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
	public static String SHA512(String source) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(source.getBytes());
			byte[] hash = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : hash) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.printf("Exception: %s, Source string: %s",
					e.getMessage(), source);
			return null;
		}	
	}
}
