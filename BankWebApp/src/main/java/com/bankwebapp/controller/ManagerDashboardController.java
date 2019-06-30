package com.bankwebapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankwebapp.services.ManagerFuncServices;

@Controller
public class ManagerDashboardController {
	
	@Autowired
	ManagerFuncServices managerFS;
	
	@RequestMapping("/managerDashboard")
	public String customerDashboard(Model model, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");

		model.addAttribute("accData", managerFS.getAccInfo());
		model.addAttribute("managerName", username);
		return "managerDashboard";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String depositing(@RequestParam("manID") String t, ModelMap model, @RequestParam("userID") String s) {
		model.put("accData", managerFS.remove(s));
		model.addAttribute("managerName", t);
		return "managerDashboard";
	}
}
