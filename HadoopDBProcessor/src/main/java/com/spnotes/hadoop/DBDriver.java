package com.spnotes.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.ObjectWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.mortbay.jetty.AbstractGenerator.OutputWriter;


public class DBDriver extends Configured implements Tool{

	public static void main(String[] argv) throws Exception{
		int exitCode = ToolRunner.run(new DBDriver(), argv);
		System.exit(exitCode);
	}

	public int run(String[] args) throws Exception {
		Job job = new org.apache.hadoop.mapreduce.Job();
	
		job.setJarByClass(DBDriver.class);
		job.setJobName("DBDriver");
		job.setInputFormatClass(DBInputFormat.class);
		
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Text.class);
		job.setMapperClass(DBMapper.class);
		
		Configuration configuration = job.getConfiguration();
		configuration.set(DBConfiguration.DRIVER_CLASS_PROPERTY, "com.mysql.jdbc.Driver");
		configuration.set(DBConfiguration.USERNAME_PROPERTY, "root");
		configuration.set(DBConfiguration.PASSWORD_PROPERTY, "");
		configuration.set(DBConfiguration.URL_PROPERTY, "jdbc:mysql://localhost:3306/test");
		configuration.set(DBConfiguration.INPUT_QUERY, "select * from Contact");
		configuration.set(DBConfiguration.INPUT_COUNT_QUERY, "select count(*) from Contact");
		configuration.set(DBConfiguration.INPUT_CLASS_PROPERTY, ContactWritable.class.getName());
		
		FileOutputFormat.setOutputPath(job, new Path(args[0]));

		
		return job.waitForCompletion(true) ? 0:1;
	}

}
