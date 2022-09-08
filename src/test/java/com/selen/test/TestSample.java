package com.selen.test;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException, Exception {
		TestApache6 td= new TestApache6();
		
	   ArrayList<String> data =   td.getData("purchase");
	   System.out.println( data.get(0));
	   System.out.println( data.get(1));
	   System.out.println( data.get(2));
	   System.out.println( data.get(3));

	}

}
