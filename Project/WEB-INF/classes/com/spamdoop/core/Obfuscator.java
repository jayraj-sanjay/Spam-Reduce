package com.spamdoop.core;

import java.io.File;

import com.spamdoop.util.RunCommand;

public class Obfuscator {

	public void run() {
		RunCommand.run("rm -rf /root/tmp");
		RunCommand.run("rm -rf /root/tmp_obf");

		RunCommand.run("mkdir /root/tmp");
		RunCommand.run("mkdir /root/tmp_obf");

		String cmd = "hadoop fs -get input/* /root/tmp/";
		RunCommand.run(cmd);
		String input = "/root/tmp/";

		File input_dir = new File(input);
		for (String f : input_dir.list()) {

			new ObfuscatorThread(f);

		}

	}

}
