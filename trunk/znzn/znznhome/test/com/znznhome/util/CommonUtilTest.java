package com.znznhome.util;

import org.junit.Test;


public class CommonUtilTest {
	@Test
	public void testRunTimeException() {
		String s = "123abc";
		int id = Integer.parseInt(s);
		System.out.println("------發生了runtime 異常， 不捕獲處理的情況-----");
	}
	
	@Test
	public void testRunTimeException2() {
		try{
			
			String s = "123abc";
			String s2 = "123abc";
			String s3 = new String("123abc");
			String s4 = new String("123abc");
			System.out.println(s == s2);
			System.out.println(s3 == s4);
			System.out.println(s.equals(s2));
			System.out.println(s.equals(s4));
			System.out.println(s3.equals(s4));
			Object o = new Object();
			Object o2 = o;
			System.out.println(o == o2);
			//int id = Integer.parseInt(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("------發生了runtime 異常， 捕獲處理之後-----");
	}
	
	@Test
	public void testRunTimeException3() throws RuntimeException{
		String s = "123abc";
		int id = Integer.parseInt(s);
		
		System.out.println("------發生了runtime 異常，聲明式拋出處理之後-----");
	}
	
	@Test
	public void testRunTimeException4() throws Exception{
		try{
			String s = "123abc";
			int id = Integer.parseInt(s);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		System.out.println("------發生了runtime 異常，捕獲處理之後，再拋出-----");
	}
	
}
