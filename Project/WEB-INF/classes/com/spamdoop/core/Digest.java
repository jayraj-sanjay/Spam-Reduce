package com.spamdoop.core;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Digest {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA");
		String msg = "Sample Message 1";
		byte[] digest = md.digest(msg.getBytes());
		String result = Arrays.toString(digest);
		System.out.println(result);

		String msg2 = "Sample Message 2";
		
		byte[] digest2 = md.digest(msg2.getBytes());
		String result2 = Arrays.toString(digest2);
		System.out.println(result2);

		if (result2.contains(result))
			System.out.println("Same");
		else
			System.out.println("Not same");

	}

}
