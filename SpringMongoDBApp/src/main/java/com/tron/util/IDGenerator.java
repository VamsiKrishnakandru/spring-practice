package com.tron.util;

import java.util.UUID;

public class IDGenerator 
{
	public static String generateId()
	{
		String id = UUID.randomUUID().toString().replace("-", "").substring(0,10);
		return id;
	}
}
