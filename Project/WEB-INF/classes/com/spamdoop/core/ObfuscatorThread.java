package com.spamdoop.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ObfuscatorThread implements Runnable {

	Thread t;
	String ff;
	String input = "/root/tmp/";
	String tmp_obf = "/root/tmp_obf/";

	public ObfuscatorThread(String file) {
		this.ff = file;
		t = new Thread(this);
		t.start();
	}

	public static String getDigest(String word) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		byte[] digest = md.digest(word.getBytes());
		return Arrays.toString(digest);
	}

	@Override
	public void run() {
		try {
			File file = new File(input + ff);
			File obfs = new File(tmp_obf + ff);

			BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(obfs)));
			String line = "";
			while ((line = br1.readLine()) != null) {
				line = line.toLowerCase();
				String words[] = line.split(" ");
				String opLine = "";
				for (String w : words) {
					w = getDigest(w);
					if (opLine.equals(""))
						opLine += w;
					else
						opLine += " " + w;
				}
				bw1.write(opLine);
				bw1.newLine();
			}
			bw1.close();
			br1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
