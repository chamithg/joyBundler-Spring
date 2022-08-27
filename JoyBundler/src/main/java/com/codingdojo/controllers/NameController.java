package com.codingdojo.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.models.Name;
import com.codingdojo.models.User;
import com.codingdojo.services.NameService;
import com.codingdojo.services.UserService;

@Controller
public class NameController {
	
	
	@Autowired
	private NameService nameServ;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/home")
	public String allNames(Model model, HttpSession session) {
		if(userServ.validateSession(session)) {
			
			model.addAttribute("names",nameServ.allNames());
			return "home.jsp";
		}
		return "redirect:/";
	}
	
	@GetMapping("/names/{id}")
	 public String display(@PathVariable("id") Long id, Model model,HttpSession session) {
		if(userServ.validateSession(session)) {
	        Name name = nameServ.findName(id);    
	        model.addAttribute("name", name);
	        return "viewName.jsp";
		}
		return "redirect:/";
    }
	
	@GetMapping("/names/new")
	public String displayNameCreate(@ModelAttribute("newName") Name newName,HttpSession session) {
		if(userServ.validateSession(session)) {
			return "addName.jsp";
		}
		return "redirect:/";
	}
	
	@PostMapping("/process/create")
	public String createName(@Valid @ModelAttribute("newName") Name newName,
			BindingResult bindingResult,
			Model model) {

		
		if(bindingResult.hasErrors()) {	 
			return "addName.jsp";
		}
		
		nameServ.createName(newName);
		
		return "redirect:/home";
		

	}
	
	@GetMapping("/names/{id}/edit")
	 public String displayEdit(@ModelAttribute("currentName") Name currentName,
			 BindingResult bindingResult,
			 HttpSession session,
			 @PathVariable("id") Long id,
			 Model model) {
		if(userServ.validateSession(session)) {
	      Name name = nameServ.findName(id); 
	      
	      model.addAttribute("currentName", name);
	      
	      System.out.println(currentName);
	       return "editName.jsp";
		}
		return "redirect:/";
   }
	
	@PostMapping("/process/update/{id}")
	public String updateName(@Valid@ModelAttribute("currentName") Name currentName,
			BindingResult bindingResult,
			 @PathVariable("id") Long id) {
		
		currentName.setId(id);
		

		if(bindingResult.hasErrors()) {	 
			return "editName.jsp";
		}
		
		nameServ.createName(currentName);
		
		return "redirect:/home";
		
	}
	
	
	@GetMapping("process/delete/{id}")
	public String deleteName(@PathVariable("id") Long id,HttpSession session) {
		if(userServ.validateSession(session)) {
			
			nameServ.deleteById(id);
			
			return "redirect:/home";
		}
		return "redirect:/";
		
	}
	
	
}
