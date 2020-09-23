package com.main.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.exceptions.UserNotFoundException;
import com.main.model.User;

@Service
public class UserService {
	
	 List<User> userList=new ArrayList<>(); 
	
	 int usersCount=3;
	 
	
	 DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
	
	{
		
			try {
				userList.add(new User(1,"Aravind",df.parse("05-06-1996"),"India") );
				userList.add(new User(2,"George",df.parse("09-02-1996"),"US") );
				userList.add(new User(3,"Mathew",df.parse("04-09-1996"),"France") );
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
	}	

	
	public List<User> findAllUser(){
		return userList;
	}
	
	public User save(User user) {
		if (user.getId()==0) {
			user.setId(++usersCount);
		}
		userList.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	/*
	 * public static Date StringToDate(String s){
	 * 
	 * Date result = null; try{ SimpleDateFormat dateFormat = new
	 * SimpleDateFormat("yyyy-MM-dd"); result = dateFormat.parse(s);
	 * 
	 * }
	 * 
	 * catch(ParseException e){ e.printStackTrace();
	 * 
	 * } return result ; }
	 */
	
}
