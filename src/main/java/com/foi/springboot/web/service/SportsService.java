package com.foi.springboot.web.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service

public class SportsService {
	public boolean updateSports(String sports) {
		 if (!sports.isEmpty()) {
	        	
 			Properties p=new Properties();  
 			p.setProperty("sports", sports);  
 			try {
 				String basePath = new File("").getAbsolutePath();
 			    System.out.println(basePath);

 			    String path = new File("src/main/resources/FOI.properties")
 			                                                           .getAbsolutePath();
 			   System.out.println(path);
 			   System.out.println(sports);
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
