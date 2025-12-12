package com.example.expenseTracker;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import eventProducer.UserInfoEvent;

public class UserInfoSerializer implements Serializer<UserInfoEvent>{	
	
	@Override
	public void configure(Map<String,?>map,boolean b) {
		
	}
	
	public byte[] serialize(String arg0, UserInfoEvent arg1) {
		byte[] retVal =null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal=objectMapper.writeValueAsString(arg1).getBytes();
			
		
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return retVal;
			
	}
	@Override public void close() {
		
	}
	

}
	