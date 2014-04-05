package com.kanchutech.eden.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	private static Properties properties;
	
	public PropertyUtil(){
		
	}
	
	static {
		properties = new Properties();
		String propertyFileName = "com/kanchutech/eden/common/application.properties";
//		String propertyFileName = "E:/eden/workspaces/first_iteration_local_ws/testbed/src/main/resources/com/kanchutech/eden/common/application.properties";
		try {
			ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
			InputStream resourceAsStream = contextClassLoader.getResourceAsStream(propertyFileName);
			properties.load(resourceAsStream);
//			properties.load(new FileInputStream(new File(propertyFileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		return properties.getProperty(key);
	}
}
