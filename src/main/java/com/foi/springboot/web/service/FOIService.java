package com.foi.springboot.web.service;

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
				p.store(new FileWriter("D:\\NewWorkplace\\Projects\\TodoApp\\src\\main\\resources\\FOI.properties"),"File Storage");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
 		//	return mapping.findForward(SUCCESS);
 			return true;
 		}
		 return false;
	}


}
