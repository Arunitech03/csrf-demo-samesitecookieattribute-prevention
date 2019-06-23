package com.foi.springboot.web.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service

public class FOIService {
	public boolean updateFOI(String foi) {
		 if (!foi.isEmpty()) {
	        	
 			Properties p=new Properties();  
 			p.setProperty("FOI", foi);  
 			try {
 				String basePath = new File("").getAbsolutePath();
 			    System.out.println(basePath);

 			    String path = new File("src/main/resources/FOI.properties")
 			                                                           .getAbsolutePath();
 			   System.out.println(path);
 			   System.out.println(foi);
 			   p.store(new FileWriter(path),"File Storage");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
 		//	return mapping.findForward(SUCCESS);
 			return true;
 		}
		 return false;
	}


}
