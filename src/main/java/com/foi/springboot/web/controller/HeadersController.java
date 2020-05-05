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
public class HeadersController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/Xframeoptions", method = RequestMethod.GET)
	public String showxframePage(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		//response.setHeader("x-frame-options", "DENY");
		return "xframe";
	}
	
	@RequestMapping(value="/cors", method = RequestMethod.GET)
	public String corsPage(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return "corspage";
	}
	
	@RequestMapping(value="/csp", method = RequestMethod.GET)
	public String cspPage(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		//response.setHeader("Content-Security-Policy", "script-src https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js 'unsafe-inline' 'unsafe-eval'");
		response.setHeader("Content-Security-Policy", "script-src 'self'");
		return "csppage";
	}
}
