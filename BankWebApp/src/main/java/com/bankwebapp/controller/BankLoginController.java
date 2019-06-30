package com.bankwebapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bankwebapp.beans.LoginBean;
import com.bankwebapp.services.LoginServices;

@Controller
@SessionAttributes({"username","role"})
public class BankLoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BankLoginController.class);
	
	@Autowired
	LoginServices loginServciesImpl;
	

	@RequestMapping(value = "/")
	public String BankLogin(Map<String, LoginBean> model) {
		return "BankLogin";
	}

	@RequestMapping(value= "/login" , method = RequestMethod.POST)
	public void submit(Model model, @ModelAttribute("banklogin") LoginBean bean, HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");   
			String password = request.getParameter("password");
			bean = new LoginBean(username,password);
			
			boolean status = loginServciesImpl.authenticateUser(bean);
			if (!status){
			       System.out.println("Invaild Username or Password"); 
			       response.sendRedirect("/");
			}
			else {				
				request.getSession().setAttribute("username", username);
				String role = loginServciesImpl.authorize(bean);
				String redirect = "/LoanLogin";
				switch(role) {
					case "manager":
						redirect = "/managerDashboard";
						break;
					case "customer":
						redirect = "/customerDashboard";
						break;
				}
				response.sendRedirect(redirect);		
			}
		} catch(Exception e) {       
			LOGGER.error("A stack trace!", e);
		} 
	}	
}