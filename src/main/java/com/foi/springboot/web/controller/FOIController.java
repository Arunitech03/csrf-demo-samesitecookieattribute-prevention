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

import com.foi.springboot.web.service.FOIService;

@Controller
@SessionAttributes("name")
public class FOIController {
	
	@Autowired
	FOIService service;
	
	@RequestMapping(value="/updatefoi", method = RequestMethod.GET)
		public String showUpdateFOIPage(ModelMap model, HttpServletResponse response){
		response.setHeader("X-XSS-Protection", "1; mode=block");
		//response.setHeader("X-XSS-PROTECTION", "1");
		response.setHeader("X-Frame-Options", "DENY");
		response.setHeader("Content-Security-Policy", "script-src 'self'");
		return "updatefoi";
	}
	
	@RequestMapping(value="/updatefoi", method = RequestMethod.POST)
	public String updatestatuspage(ModelMap model, @RequestParam String foi, HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		String uname = null;
		 Cookie[] cookies = request.getCookies();
		    if (cookies != null) {
		        for (Cookie cookie : cookies) {
		            if (cookie.getName().equals("uname")) { 
		            	uname = cookie.getValue();
		            }
		        }
		    }
		
		if(session != null && uname.equals(session.getAttribute("name"))){
			session.setAttribute("foi", foi);
			boolean isupdatefoi = service.updateFOI(foi);
			if (!isupdatefoi) {
				model.put("errorMessage", "FOI Not Updated. Please try Again");
				return "updatefoi";
			}
			response.setHeader("X-XSS-Protection", "1; mode=block");
			//response.setHeader("Content-Security-Policy", "script-src 'self'");
			//response.setHeader("x-xss-protection", "1; mode=block");
			return "viewupdatedfoi";
		}
		model.put("errorMessage", "Please login Again");
		return "login";
		
		
	}
}