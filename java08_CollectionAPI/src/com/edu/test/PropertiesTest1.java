package com.edu.test;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest1 {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		Enumeration en = p.propertyNames();
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value = p.getProperty(name);
			
			System.out.println(name+"==========="+value);
		}
	}

}
