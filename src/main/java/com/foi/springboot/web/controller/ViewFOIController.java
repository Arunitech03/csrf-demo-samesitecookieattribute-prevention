package com.foi.springboot.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.foi.springboot.web.service.LoginService;
import com.foi.springboot.web.service.TodoService;

@Controller
@SessionAttributes("name")
public class ViewFOIController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/displayfoi", method = RequestMethod.GET)
	public String showTodos(ModelMap model, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "http://10.1.25.57:8877");
		return "viewupdatedfoi";
	}
}
