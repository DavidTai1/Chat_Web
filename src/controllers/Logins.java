package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dataAccess.Dao;
import data_objects.Chatlogs;
import data_objects.Friends;
import data_objects.Users;


@Controller
public class Logins {
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;
	

	Dao d = new Dao();
	
	@GetMapping("/login")
	public String redirectGetLoginAttempts() throws IOException{
		Users u = (Users) session.getAttribute("loggedInUser");
		if (u != null){
			return "loggedin";
		}
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(@RequestParam String username, @RequestParam String password){
		if (session.getAttribute("loggedInUser")!= null){
			return "loggedin";
		}
		if (username == ""){
			return "login.jsp?err=2";
		}
		
		Users u = d.getUser(username);
		
		if(u == null){
			return "login.jsp?err=1";
		}
		if(!u.getPassword().equals(password)){
			return "login.jsp?err=1";
		}
		
		session.setAttribute("loggedInUser", u);

		List<Friends> f = (List<Friends>) d.getFriends(u.getUsername());
		List<Chatlogs> l = (List<Chatlogs>) d.retriveChatlogs();

		for(Chatlogs c: l){
			System.out.println(">>>>>>>> from: "+ c.getFrom_userid()+"  to: "+ c.getTo_userid()+" message: "+ c.getMessage());
		}
		System.out.println("size: "+f.size()+"   "+l.size());
		session.setAttribute("friendlist", f);
	
		session.setAttribute("chatlogs", l);
		return "loggedin";
	}
	
	@GetMapping("/loggedin")
	public String redirectGetLoggedIn(HttpServletRequest request){
		return "loggedin";
	}

	
	@GetMapping("/logout")
	public String redirectToIndex(){
		session.invalidate();
		return "../../index";
	}
}
