package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dataAccess.Dao;
import data_objects.Users;

@Controller
public class FrontController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;
	
	Dao d = new Dao();
	
	
	@PostMapping("/back")
	public String goBack(){
		return "../../index";
	}
	@GetMapping("/register")
	public String redirectGetRegisterAttempts(){
		return "register";
	}
	@PostMapping("/register")
	public String doRegister(@RequestParam String username, @RequestParam String password, HttpServletResponse response) throws IOException, ServletException{
		if (username == ""){
			return "register.jsp?err=3";
		}
		
		Users u = d.getUser(username);
		
		if(u != null){
			return "register.jsp?err=1";
		}
		u=new Users(username,password);
		d.addUser(u);
		
		session.setAttribute("loggedInUser", u);
		
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		return "loggedin";
	}
}
