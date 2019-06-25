package com.foi.springboot.web.controller;

import java.io.IOException;

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

import com.foi.springboot.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		
		boolean isValidUser = service.validateUser(name, password);
		
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		session.invalidate();
	   
		/*
		 * Cookie ck=new Cookie("uname",name); ck.setMaxAge(1000000);//changing the
		 * maximum age to 0 seconds response.addCookie(ck);//adding cookie in the
		 * response
		 */	    
		response.setHeader("Set-Cookie", "uname1="+name+"; HttpOnly; SameSite=lax"); //strict
		//response.setHeader("Set-Cookie", "uname1="+name+"; HttpOnly");
		model.put("name", name);
		model.put("password", password);
		HttpSession newSession = request.getSession();
		newSession.setAttribute("user", name);// create session
		return "welcome";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String WelcomePage(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		return "welcome";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
	session.invalidate();
	Cookie[] cookies = request.getCookies();
	cookies[0].setMaxAge(0);
	response.addCookie(cookies[0]);
	//response.sendRedirect("/login");
    return "login";
	}
}
