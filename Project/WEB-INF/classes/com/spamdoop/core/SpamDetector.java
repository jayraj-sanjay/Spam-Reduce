package com.spamdoop.core;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.spamdoop.util.RunCommand;

public class SpamDetector {

	public static String getDigest(String word) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		byte[] digest = md.digest(word.getBytes());
		return Arrays.toString(digest);
	}

	public static void run() throws Exception {
		RunCommand.run("rm -rf /root/result");

		RunCommand.run("mkdir /root/result");

		// Copy all the files from hadoop FS to local FS

		String input = "/root/tmp_obf/";

		File input_dir = new File(input);
		for (String f : input_dir.list()) {

			new SpamDetectorThread(f);

		}

	}

}
