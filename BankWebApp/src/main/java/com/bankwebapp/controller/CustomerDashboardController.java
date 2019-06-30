package com.bankwebapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankwebapp.services.CustomerFuncServices;

@Controller
public class CustomerDashboardController {
	
	@Autowired
	CustomerFuncServices customerFS;	
	
	@RequestMapping("/customerDashboard")
	public String customerDashboard(Model model, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");

		model.addAttribute("accData", customerFS.getAccInfo(username));
		model.addAttribute("customerName", username);
		return "customerDashboard";
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public String depositing(@RequestParam("dep") String t, ModelMap model, @RequestParam("custId") String s) {
		model.put("accData", customerFS.deposit(s, Double.parseDouble(t)));
		model.addAttribute("customerName", s);
		return "customerDashboard";
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String withdrawing(@RequestParam("wit") String t, ModelMap model, @RequestParam("custId") String s) {
		model.put("accData", customerFS.withdraw(s, Double.parseDouble(t)));
		model.addAttribute("customerName", s);
		return "customerDashboard";
	}
}