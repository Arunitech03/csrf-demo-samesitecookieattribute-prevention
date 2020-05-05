package com.foi.springboot.web.controller;

import java.io.IOException;
import java.util.Base64;

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
@SessionAttributes("fsession")
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
		String ckvalue = name + "Oi8veGNsb3VkLnh5bGVtLmNvbS90aWQiOlsiRlNULTE1MzgzODgzMzg";
		//response.setHeader("Set-Cookie", "fsession="+Base64.getEncoder().encodeToString(ckvalue.getBytes())+"; SameSite=lax"); //strict
		response.setHeader("Set-Cookie", "fsession="+Base64.getEncoder().encodeToString(ckvalue.getBytes())+"; HttpOnly; SameSite=lax"); //strict
		//response.setHeader("Set-Cookie", "fsession="+Base64.getEncoder().encodeToString(ckvalue.getBytes()));
		model.put("name", name);
		model.put("password", password);
		HttpSession newSession = request.getSession();
		newSession.setAttribute("fsession", Base64.getEncoder().encodeToString(ckvalue.getBytes()));// create session
		return "welcome2";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String WelcomePage(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		return "welcome2";
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
