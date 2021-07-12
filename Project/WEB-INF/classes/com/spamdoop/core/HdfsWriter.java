package com.spamdoop.core;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.ToolRunner;

public class HdfsWriter extends Configured implements Tool {

	public static final String FS_PARAM_NAME = "fs.defaultFS";

	public int run(String[] args) throws Exception {

		
		//Input stream for the file in local file system to be written to HDFS
		InputStream in = new BufferedInputStream(new FileInputStream(args[0]));

		//Get configuration of Hadoop system
		Configuration conf = new Configuration();
		System.out.println("Connecting to -- "+conf.get("fs.defaultFS"));

		//Destination file in HDFS
		FileSystem fs = FileSystem.get(URI.create(args[1]), conf);
		OutputStream out = fs.create(new Path(args[1]));

		//Copy file from local to HDFS
		IOUtils.copyBytes(in, out, 4096, true);

		System.out.println(args[1] + " copied to HDFS");


		/*
		String localInputPath = args[0];
		System.out.println("Input : "+args[0]);
		System.out.println("Output : "+args[1]);   
		Path outputPath = new Path(args[1]);
		Configuration conf = getConf();
		conf.set(FS_PARAM_NAME, "hdfs:///");
		System.out.println("configured filesystem = " + conf.get(FS_PARAM_NAME));
		FileSystem fs = FileSystem.get(conf);
		if (fs.exists(outputPath)) {
			System.err.println("output path exists");
			return 1;
		}
		OutputStream os = fs.create(outputPath);
		InputStream is = new BufferedInputStream(new FileInputStream(localInputPath));
		IOUtils.copyBytes(is, os, conf);
		os.close();
		is.close();
		*/
		return 0;
	}

	public static void main(String[] args) throws Exception {
		int returnCode = ToolRunner.run(new HdfsWriter(), args);
		System.exit(returnCode);
	}
}