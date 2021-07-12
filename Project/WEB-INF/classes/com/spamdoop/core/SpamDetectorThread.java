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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpamDetectorThread implements Runnable {

	Thread t;
	String tmp_obf = "/root/tmp_obf/";
	String spam_words = "/root/spamwords/spamwords.txt";
	String result = "/root/result/results.txt";

	String fl;

	public SpamDetectorThread(String f) {
		fl = f;
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

			File obfs = new File(tmp_obf + fl);

			// BufferedReader br1 = new BufferedReader(new InputStreamReader(new
			// FileInputStream(file)));
			// BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new
			// FileOutputStream(obfs)));
			// String line = "";
			// while ((line = br1.readLine()) != null) {
			// line = line.toLowerCase();
			// String words[] = line.split(" ");
			// String opLine = "";
			// for (String w : words) {
			// w = getDigest(w);
			// if (opLine.equals(""))
			// opLine += w;
			// else
			// opLine += " " + w;
			// }
			// bw1.write(opLine);
			// bw1.newLine();
			// }
			// bw1.close();
			// br1.close();

			BufferedWriter bw_result = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File(result), true)));

			BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(obfs)));
			boolean is_spam = false;
			List<String> spams = new ArrayList<>();
			String email_line = "";
			String spam_line = "";
			while ((email_line = br1.readLine()) != null) {

				String encoded_spam_line = "";
				String plain_spam_line = "";
				BufferedReader br2 = new BufferedReader(
						new InputStreamReader(new FileInputStream(new File(spam_words))));

				while ((spam_line = br2.readLine()) != null) {
					if (spam_line.trim().length() > 0) {
						spam_line = spam_line.toLowerCase();
						String words[] = spam_line.split(" ");
						plain_spam_line = spam_line;

						for (String w : words) {
							w = getDigest(w);
							if (encoded_spam_line.equals("")) {
								encoded_spam_line += w;

							} else {
								encoded_spam_line += " " + w;
							}
						}
						if (email_line.contains(encoded_spam_line)) {
							if (!spams.contains(plain_spam_line)) {
								spams.add(plain_spam_line);
							}
							// is_spam = true;
						}
					}

					encoded_spam_line = "";
					plain_spam_line = "";

				}

				br2.close();

			}

			if (spams.size() > 4) {
				is_spam = true;
			}

			System.out.println("RESULT : IS SPAM ? : " + is_spam);

			String reason = "";
			for (String t : spams) {
				reason += t + ",";
			}

			bw_result.write(fl + "@-@-" + String.valueOf(is_spam) + "@-@-" + reason);
			bw_result.newLine();
			br1.close();

			bw_result.close();

		} catch (Exception e) {
			System.out.println("Exception inside the Spam Detector Thread");
		}
	}

}
