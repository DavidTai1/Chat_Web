package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dataAccess.Dao;
import data_objects.Chatlogs;
import data_objects.Friends;
import data_objects.Users;

@Controller
public class Message {
	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;	
	
	Dao d = new Dao();
	public List<Chatlogs> l = (List<Chatlogs>) d.retriveChatlogs();
	
	@PostMapping("/sendmsg")
	@ResponseBody public String doLogin(@RequestParam("touser") String to,@RequestParam("usermsg") String msg) throws ScriptException, IOException, NoSuchMethodException{
		if(to == null || to.length()==0){
			return "error";
		}
		String from = ((Users) session.getAttribute("loggedInUser")).getUsername();
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss").format(new java.util.Date());
		Chatlogs chat = new Chatlogs(from,to,timeStamp,msg);
		d.addChatlogs(chat);
		l = (List<Chatlogs>) d.retriveChatlogs();
		List<Chatlogs> nl = new ArrayList<Chatlogs>();
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<user: "+from+ "to:  "+to+"size:  "+l.size());
		
		for(Chatlogs c:l){

			if((c.getFrom_userid().equals(from) && c.getTo_userid().equals(to)) || (c.getFrom_userid().equals(to) && c.getTo_userid().equals(from))){
				nl.add(c);
			}	
		}
		return timeStamp;
	}
	
	@PostMapping("/updatedialog")
	@ResponseBody public List<Chatlogs> updateDia(@RequestParam("touser") String to){
		String from = ((Users) session.getAttribute("loggedInUser")).getUsername();		
		List<Chatlogs> nl = new ArrayList<Chatlogs>();
		for(Chatlogs c:l){
			if(to.equals("PubChat")){
				if(c.getTo_userid().equals(to)){
					nl.add(c);
				}
			}
			else{
				if((c.getFrom_userid().equals(from) && c.getTo_userid().equals(to)) || (c.getFrom_userid().equals(to) && c.getTo_userid().equals(from))){
					nl.add(c);
				}
			}
				
		}
		return nl;
	}
	
	@PostMapping("/addfriend")
	public String addFriend(@RequestParam("addname") String who){
		String from = ((Users) session.getAttribute("loggedInUser")).getUsername();
		if(from.equals(who)){
			return "loggedin.jsp?err=1";
		}
		if(session.getAttribute("friendlist")!=null){
			for(Friends ff:(List<Friends>)session.getAttribute("friendlist")){
				if(ff.getFriendid().equals(who)){
					return "loggedin.jsp?err=3";
				}
			}
		}
		Users u = d.getUser(who);
		if(u!=null){
			d.addFriends(from, who);
			List<Friends> f = (List<Friends>) d.getFriends(from);
			if(session.getAttribute("friendlist") != null){
				session.removeAttribute("friendlist");
			}
			session.setAttribute("friendlist", f);
			
			return "loggedin";
		}
		
		return "loggedin.jsp?err=2";
		
	}
}
