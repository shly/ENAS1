package com.neusoft.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.neusoft.model.UserT;
import com.neusoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction  extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserT user;
	private UserService userService;
	private String userName;
	private String password;
	private String msg;
	private Map<String, Object> session;
	
	public String login(){
		if(userName != null){
			user = userService.findUserByName(userName);
			if(user == null){
				msg = "对不起，没有该用户";
				return ERROR;
			}else if(!user.getUserPassword().equals(password)){
				msg = "对不起,请输入正确密码";
				return ERROR;
			}else{
				session.put(userName, "login_success");
				session.put("current_user", userName);
				return SUCCESS;
			}
		}
		return ERROR;
	}
	public String logout(){
		if(session.containsKey("current_user")){
			String name = (String) session.get("current_user");
			session.put(name, "logout_success");
			return SUCCESS;
		}
		return ERROR;
	}
	
	public UserT getUser() {
		return user;
	}
	public void setUser(UserT user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
