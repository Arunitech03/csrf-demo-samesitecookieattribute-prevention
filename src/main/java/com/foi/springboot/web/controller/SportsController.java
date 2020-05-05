package com.foi.springboot.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.foi.springboot.web.service.SportsService;

@Controller
@SessionAttributes("fsession")
public class SportsController {
	
	@Autowired
	SportsService service;
	
	@RequestMapping(value="/sportsupdateform", method = RequestMethod.GET)
		public String showGetUpdateSportsPage(ModelMap model, HttpServletResponse response){
		//response.setHeader("X-XSS-Protection", "1; mode=block");
		//response.setHeader("X-XSS-PROTECTION", "1");
		response.setHeader("x-frame-options", "DENY");
		response.setHeader("content-security-policy", "script-src 'self'");
		return "updatesportsform";
	}
	
	@RequestMapping(value="/updatesports", method = RequestMethod.POST)
	public String postupdatestatuspageSports(ModelMap model, @RequestParam String sports, HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		String fsessionvalue = null;
		 Cookie[] cookies = request.getCookies();
		    if (cookies != null) {
		        for (Cookie cookie : cookies) {
		            if (cookie.getName().equals("fsession")) { 
		            	fsessionvalue = cookie.getValue();
		            }
		        }
		    }
		    
		    System.out.println(fsessionvalue);
		    System.out.println(session!=null);
		    System.out.println(session.getAttribute("fsession"));
		
		//if(session != null && uname.equals(session.getAttribute("name"))){
		    if(session != null && fsessionvalue.equals(session.getAttribute("fsession"))){
		    	
			session.setAttribute("sports", sports);
			boolean isupdatesports = service.updateSports(sports);
			if (!isupdatesports) {
				model.put("errorMessage", "Sports Not Updated. Please try Again");
				return "updatesports";
			}
			//response.setHeader("x-xss-protection", "1; mode=block");
			//response.setHeader("content-security-policy", "script-src 'self'");
			return "viewupdatedsports";
		}
		model.put("errorMessage", "Please login Again");
		return "login";
		
		
	}
	
	@RequestMapping(value="/viewsports", method = RequestMethod.GET)
	public String showsportsPage(ModelMap model, HttpServletResponse response){
	response.setHeader("x-xss-protection", "1; mode=block");
	//response.setHeader("x-frame-options", "DENY");
	//response.setHeader("content-security-policy", "script-src 'self'");
	return "viewupdatedsports";
}
	@RequestMapping(value="/viewsportsencoded", method = RequestMethod.GET)
	public String showencodedsportsPage(ModelMap model, HttpServletResponse response){
	response.setHeader("x-xss-protection", "1; mode=block");
	//response.setHeader("x-frame-options", "DENY");
	//response.setHeader("content-security-policy", "script-src 'self'");
	return "viewupdatedsportsenc";
}
}