package com.spnotes.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.ObjectWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class DBMapper extends Mapper<LongWritable, DBWritable, IntWritable, Text>{

	@Override
	protected void map(LongWritable key, DBWritable value,
			org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {
		System.out.println("Inside DBMapper.map");
		ContactWritable contactWritable = (ContactWritable)value;
		Contact contact = contactWritable.getContact();
		System.out.println(contact);		
		context.write(new IntWritable(contact.getContactId()),new Text(contact.toString()) );
		  
	}

}
