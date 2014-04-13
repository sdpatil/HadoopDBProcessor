package com.spnotes.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DBReducer extends Reducer<IntWritable, Text, IntWritable, Text>{

	@Override
	protected void reduce(IntWritable arg0, Iterable<Text> arg1,
			Context arg2)
			throws IOException, InterruptedException {
		
		super.reduce(arg0, arg1, arg2);
	}

}
