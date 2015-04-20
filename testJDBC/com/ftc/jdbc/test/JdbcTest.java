package com.ftc.jdbc.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JdbcTest {
	    // MD5加密   
	        public String encrypt(String msg) { 
	        	byte[] digest=new byte[1024];
	        	String result="";
	        	try {   
	        	     MessageDigest md5 = MessageDigest.getInstance("MD5");
	        	     md5.update(msg.getBytes());     // 添加要计算的摘要信息   
	        	     digest = md5.digest();
	        	     }
	        	 catch(NoSuchAlgorithmException e) {   
	        	     e.printStackTrace(); 
	        	 }
	        	
	        	for(int i=0;i<digest.length;i++) 
	        	 {   
	        		     result+=(Integer.toHexString(digest[i] & 0XFF));   
	        	 }
	        	    return result.toLowerCase(); 
	        	}
	        
	        public static void main(String[] args) {
	        	JdbcTest jd =new JdbcTest();
				System.out.println(jd.encrypt("11"));
			}

	    

}  


